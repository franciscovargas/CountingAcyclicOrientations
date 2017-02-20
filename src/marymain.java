public class marymain{
    public static boolean[][]  buildTreeTriangle() {
	boolean[][] graph = new boolean[9][9];
	int i, j;
        for (i=0; i < 9; i++)
	    for (j=0; j<9; j++) 
		graph[i][j] = false;
	graph[3][4]=true;
	graph[4][3]=true;
	graph[0][1]=true;
	graph[1][0]=true;
	graph[0][2]=true;
	graph[2][0]=true;
	graph[1][3]=true;
	graph[3][1]=true;
	graph[1][4]=true;
	graph[4][1]=true;
	graph[2][5]=true;
	graph[5][2]=true;
	graph[2][6]=true;
	graph[6][2]=true;
	graph[3][8]=true;
	graph[8][3]=true;
	graph[3][7]=true;
	graph[7][3]=true;
	return graph;
    }

    public static boolean[][]  buildTreeSixcycle() {
	boolean[][] graph = new boolean[9][9];
	int i, j;
        for (i=0; i < 9; i++)
	    for (j=0; j<9; j++) 
		graph[i][j] = false;
	graph[0][1]=true;
	graph[1][0]=true;
	graph[0][2]=true;
	graph[2][0]=true;
	graph[1][3]=true;
	graph[3][1]=true;
	graph[1][4]=true;
	graph[4][1]=true;
	graph[3][5]=true;
	graph[5][3]=true;
	graph[3][6]=true;
	graph[6][3]=true;
	graph[5][7]=true;
	graph[7][5]=true;
	graph[5][8]=true;
	graph[8][5]=true;
	graph[2][8]=true;
	graph[8][2]=true;
	return graph;
    }

    public static void main(String [] main) {
	int i,j, k;
	double four, p;
	boolean[][] test = new boolean[5][5];
	boolean[][] testgraph;
        for (i=0; i<5; i++)
	    for (j=0; j<5; j++) 
		test[i][j] = false;
	test[0][1]=true;
	test[1][2]=true;
	test[2][3]=true;
	test[3][4]=true;
	test[4][0]=true;
	System.out.println("TASK 1: sink-elimination algorithm.");
	System.out.println("Test 1(a): directed 5-cycle.");
	if (isDAG(test))
	    System.out.println("isDAG says a DAG (error).");
	else
	    System.out.println("isDAG says not a DAG (correct).");
        for (i=0; i<5; i++)
	    for (j=0; j<5; j++) 
		test[i][j] = false;
        test[0][1]=true;
	test[1][2]=true;
	test[2][3]=true;
	test[3][4]=true;
        test[0][4]=true;
        test[1][3]=true;
	System.out.println("Test 1(b): near-directed cycle with a crossbar");
	if (isDAG(test))
            System.out.println("isDAG says a DAG (correct).");
        else
            System.out.println("isDAG says not a DAG (error).");
        for (i=0; i<5; i++)
	    for (j=0; j<5; j++) 
		test[i][j] = false;
        test[0][1]=true;
	test[1][2]=true;
	test[2][3]=true;
	test[2][4]=true;
        test[0][4]=true;
        test[1][3]=true;
	System.out.println("Test 1(c): acyclic with two initial sinks");
	if (isDAG(test))
            System.out.println("isDAG says a DAG (correct).");
        else
            System.out.println("isDAG says not a DAG (error).");
        for (i=0; i<5; i++)
	    for (j=0; j<5; j++) 
		test[i][j] = false;
	test[1][2]=true;
	test[2][3]=true;
	test[2][4]=true;
        test[0][4]=true;
	test[3][1]=true;
	test[1][0]=true;
	System.out.println("Test 1(d): cyclic, 1 initial sink, creates a 2nd");
	if (isDAG(test))
            System.out.println("isDAG says a DAG (error).");
        else
            System.out.println("isDAG says not a DAG (correct).");
	System.out.println("------------------------------------------------");
	System.out.println("Task 2: Testing AOs uniform sampler.");
	testgraph = buildTreeTriangle();
	testgraph = uniformOrient(testgraph);
	k=0;
	for (i=0; i< 9; i++)
	    for (j=i+1; j < 9; j++) {
		if (testgraph[i][j] && testgraph[j][i]) 
		    k++;
	    }
	if (k >0) 
	    System.out.println("Test 2(a):" + k + " symmetric arcs (error)");
	else 
	    System.out.println("Test 2(a): no symmetric arcs (correct)"); 
	testgraph = buildTreeTriangle();
	k=0;
	for (i=0; i <40; i++) {
	    if (isDAG(uniformOrient(testgraph))) 
		k++;
	}
	System.out.println("Test 2(b): " + k + " of the 40 Os of treeTriangle were acyclic, expected value is 30");
	testgraph=buildTreeSixcycle();
	k=0;
	for (i=0; i <40; i++) {
	    if (isDAG(uniformOrient(testgraph))) 
		k++;
	}
	System.out.println("Test 2(c): " + k + " of the 40 Os of treeSixcycle were acyclic, expected value is 38.75");
	System.out.println("------------------------------------------------");
	System.out.println("Task 3: Testing Erdos-Renyi");
	k=0;
	for (i=0; i <20; i++) {
	    testgraph = erdosRenyi(8, 0.25);
	    if (testgraph[6][7] && testgraph[7][6]) 
		k++;
	    else if (testgraph[6][7] || testgraph[7][6]) 
		System.out.println("ERROR: erdos-Renyi not returning symmetric graph");
	}
	System.out.println("Test 3: " + k + " randomly generated 20 erdos-Renyi's for n=8, p=1/4");
	System.out.println("contain the edge (6,7).  The expectation for this is 5.");
	System.out.println("------------------------------------------------");
	System.out.println("Task 5: DP algorithm");
	System.out.println("Test 5(a): with n=3, p=0.25, we get " + String.format("%.6f", expErdosRenyi(3, 0.25)) + ", should be 1.921875");
	System.out.println("Test 5(b): with n=4, p=0.5, we get " + String.format("%.6f", expErdosRenyi(4, 0.5)) + ", should be 8.484375");
	System.out.println("Test 5(c): with n=8, p=0.25, we get " + String.format("%.6f", expErdosRenyi(8, 0.25)) + ", should be 202.726892");
	System.out.println("Test 5(d): with n=8, p=0.5, we get " + String.format("%.6f", expErdosRenyi(8, 0.5)) + ", should be 2919.518684");
	// p = 0.5;
	// four = Math.pow(1-p,6) + Math.pow(1-p,5)*p*6*2;
	// four = four + Math.pow(1-p,4)*p*p*15*4;
	// four = four + Math.pow(1-p,3)*p*p*p*(4*6+16*8);
	// four = four + Math.pow(p,4)*(1-p)*(1-p)*(3*14+12*12);
	// four = four + Math.pow(p,6)*6*4 + 6*Math.pow(p,5)*(1-p)*6*3;
	// System.out.println("Case of p = 0.5, n=4 is " + four);
	System.out.println("------------------------------------------------");
	System.out.println("Task 6: Sampling algorithm");
	System.out.println("Test 6(a): with n=3, p=0.25, k=5 we get " + String.format("%.6f", estimErdosRenyi(3, 0.25, 5)) + ", exact gives 1.921875");
	System.out.println("Test 6(b): with n=4, p=0.5, k=5 we get " + String.format("%.6f", estimErdosRenyi(4, 0.5, 5)) + ", exact gives 8.484375");
	System.out.println("Test 6(c): with n=8, p=0.25, k=10 we get " + String.format("%.6f", estimErdosRenyi(8, 0.25, 10)) + ", exact gives 202.726892");
	System.out.println("Test 6(d): with n=8, p=0.25, k=100 we get " + String.format("%.6f", estimErdosRenyi(8, 0.25, 100)) + ", exact gives 202.726892");
	System.out.println("Test 6(e): with n=8, p=0.5, k=10 we get " + String.format("%.6f", estimErdosRenyi(8, 0.5, 10)) + ", exact gives 2919.518684");
	System.out.println("Test 6(f): with n=8, p=0.5, k=100 we get " + String.format("%.6f", estimErdosRenyi(8, 0.5, 100)) + ", exact gives 2919.518684");
    }

}