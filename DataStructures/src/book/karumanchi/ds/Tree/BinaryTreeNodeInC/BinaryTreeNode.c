#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Binary Tree ADT implementation

/* Includes following functions
	01. Function to create and return a node
	02. Function to traverse the tree in PreOrder
	03. Function to count the number of nodes in the tree
	04. Function to delete the tree
	05. Function to find the height of the tree
	06. Function to mirror the binary tree
	07. Function to print root-to-leaf paths, one per line
	08. Function to traverse the tree in LevelOrder (Recursive)
	09. Function to traverse the tree in LevelOrder spiral form (Recursive)
	10. Function to calculate the diameter of the tree
	11. Function that returns true if the root-leaf-path is equal to given number
	12. Function to find LCA of a binary tree
	13. Function to print a binary tree in vertical order
	14. Function to return sum of a binary tree in vertical order
	15. Function to check if the tree has children sum property
	16. Function to convert a Binary Tree into a tree that holds Children Sum Property
	17. Function that returns the number of leaf nodes
*/

struct node {
	int data;
	struct node *left;
	struct node *right;
};


// Helper function to find the maximum of two numbers
int max(int a, int b){
	if (a > b){
		return a;
	}
	else {
		return b;
	}
}

// Creates and returns a new node
struct node * newNode(int data){
	struct node *temp = (struct node *)malloc(sizeof(struct node));
	
	if(!temp){
		printf("Memory Error while creating a new node.\n");
		return 0;
	}
	
	temp->data = data;
	temp->left = NULL;
	temp->right = NULL;
	
	return(temp);
}

// Traverses the tree in PreOrder and prints the node values
void printPreOrder(struct node *r){
	
	if (r == NULL){
		return;
	}
	
	printf("%d\t", r->data);
	printPreOrder(r->left);
	printPreOrder(r->right);
	
}

// Returns the total number of nodes
int count (struct node *r){
	
	if(r == NULL){
		return 0;
	}
	
	return(count(r->left) + count(r->right) + 1);
}

// Function to delete the tree
void deleteTree(struct node *r){
	if(r == NULL){
		return;
	}
	
	deleteTree(r->left);
	deleteTree(r->right);
	printf("\nDeleting node %d", r->data);
	free(r);
	
}


// Function to find the maximum depth of a tree
int findTreeDepth(struct node *r){
	
	int lDepth, rDepth;
	
	if(r == NULL){
		return 0;
	}
	else{
	
		lDepth = findTreeDepth(r->left);
		rDepth = findTreeDepth(r->right);
	
		if (lDepth > rDepth){
			return lDepth+1;
		}
		else {
			return rDepth+1;
		}
	}
	
}

// Function to convert a Binary Tree into its mirror tree
void mirrorBinaryTree(struct node *r){
	
	struct node *temp = (struct node *)malloc(sizeof(struct node));
	
	if (r == NULL){
		return;
	}
	
	mirrorBinaryTree(r->left);
	mirrorBinaryTree(r->right);
	
	temp = r->left;
	r->left = r->right;
	r->right = temp;
	
}

// Helper Function for printPaths (printPathRecur)
void printArray(int path[], int pathlen){
	int i;
	
	for(i = 0; i < pathlen; i++){
		printf("%d\t", path[i]);
	}
	
	printf("\n");
}

// Helper Function for printPaths
void printPathRecur(struct node *r, int path[], int pathlen){
	
	if(r == NULL){
		return;
	}

	path[pathlen] = r->data;
	pathlen++;

	if (r->left == NULL && r->right == NULL){
		printArray(path, pathlen);
	}
	else{
		printPathRecur(r->left, path, pathlen);
		printPathRecur(r->right, path, pathlen);
	}
	
	}

// Function that prints all root-to-leaf paths, one per line
void printPaths(struct node *r){
	int path[1000];
	printf("\nBelow are all root-to-leaf paths : \n");
	printPathRecur(r, path, 0);
}


// Helper function for printLevelOrder
// Prints all the nodes at a particular level
void printLevelNodes(struct node *r, int level){
	if (r==NULL){
		return;
	}
	
	if (level==1){
		printf("%d\t",r->data);
	}
	else {
		printLevelNodes(r->left, level-1);
		printLevelNodes(r->right, level-1);
	}
}

// Function to print level order traversal of the tree
void printLevelOrder(struct node *r){
	int h = findTreeDepth(r);
	
	int i;
	
	for (i=1; i<=h; i++){
		printLevelNodes(r, i);
	}
}

// Helper function for printLevelOrderSpiral
// Prints all the nodes at a particular level based the spiral flag
void printLevelNodesSpiral(struct node *r, int level, bool x){
	if (r==NULL){
		return;
	}
	
	if (level==1){
		printf("%d\t",r->data);
	}
	else {
		if (x==0){
			printLevelNodesSpiral(r->left, level-1, x);
			printLevelNodesSpiral(r->right, level-1, x);
		}
		else {
			printLevelNodesSpiral(r->right, level-1, x);
			printLevelNodesSpiral(r->left, level-1, x);
		}
	}
}

// Function to print level order traversal in spiral form
void printLevelOrderSpiral(struct node *r){
	int h = findTreeDepth(r);
	
	int i;
	bool x=0;
	
	for (i=1; i<=h; i++){
		printLevelNodesSpiral(r, i, x);
		
		x = !x;
	}
	
}


// Function returns the count of leaf nodes
int countLeafNodes(struct node *r){
	
	if (r==NULL){
		return 0;
	}
	
	if(r->left==NULL && r->right==NULL){
		return 1;
	}
	else {
		return countLeafNodes(r->left)+countLeafNodes(r->right);
	}
}


//Function to calculate the diameter of the tree
int calculateDiameter(struct node *r){
	if (r == NULL){
		return 0;
	}
	
	int lheight = findTreeDepth(r->left);
	int rheight = findTreeDepth(r->right);
	
	int ldiameter = calculateDiameter(r->left);
	int rdiameter = calculateDiameter(r->right);
	
	return max((lheight + rheight + 1), max (ldiameter, rdiameter));
}


//Function that returns true if the root-leaf-path is equal to given number
bool hasPathSum (struct node *r, int sum){
	if (r == NULL){
		return (sum == 0);
	}
	else {
		bool flag =  0;
		
		int remainingSum = sum - r->data;
		if (remainingSum == 0 && r->left == NULL && r->right == NULL){
			return 1;
		}
		
		if(r->left){
			flag = flag || hasPathSum(r->left, remainingSum);
		}
		if(r->right){
			flag = flag || hasPathSum(r->right, remainingSum);
		}
	}
}


//Function to find LCA of a binary tree
struct node *findLCA(struct node *r, int a, int b){
	if (r == NULL){
		return NULL;
	}
	
	//struct node *lLCA = NULL, *rLCA = NULL;
	
	if (r->data == a || r->data == b){
		return r;
	}
	
	struct node *lLCA = findLCA(r->left, a, b);
	struct node *rLCA = findLCA(r->right, a, b);
	
	if (lLCA != NULL && rLCA != NULL){
		return r;
	}
	else {
		return((lLCA != NULL) ? lLCA : rLCA);
	}
}


//Helper function to find min max distances from the root
void findMinMax(struct node *r, int *min, int *max, int hd){
	if (r == NULL){
		return;
	}
	
	if (hd < (*min)){
		(*min) = hd;
	}
	else if (hd > (*max)){
		(*max) = hd;
	}
	
	findMinMax(r->left, min, max, hd-1);
	findMinMax(r->right, min, max, hd+1);
	
}


//Helper function to print one vertical row
void printVerticalLevel(struct node *r, int vertical_level, int hd){
	if (r == NULL){
		return;
	}
	
	if (vertical_level == hd){
		printf("%d\t", r->data);
	}
	
	printVerticalLevel(r->left, vertical_level, hd-1);
	printVerticalLevel(r->right, vertical_level, hd+1);
}


//Function to print a binary tree in vertical order
void printVertical(struct node *r){
	if (r == NULL){
		return;
	}
	
	int min=0, max=0;
	findMinMax(r, &min, &max, 0);
	
	int i;
	for (i = min; i <= max; i++){
		printf("\n");
		printVerticalLevel(r, i, 0);
	}
	
}


//Helper function to calculate vertical sum at each level
void findVerticalLevelSum(struct node *r, int vertical_level, int hd, int *verticalSum){
	if (r == NULL){
		return;
	}
	
		//	printf("\n==VerticalSUm   %d\n", vertical_level);

	
	if (vertical_level == hd){
		
		(*verticalSum) = (*verticalSum) + r->data;
		//printf("\nVerticalSUm   %d    ", verticalSum);
		//printf("%d\t", r->data);
	}
	
	
	
	//printf("\n-----%d", verticalSum);
	//printf("\n%d---%d---%d---%d", vertical_level, r->data, hd, *verticalSum);
	findVerticalLevelSum(r->left, vertical_level, hd-1, verticalSum);
	findVerticalLevelSum(r->right, vertical_level, hd+1,verticalSum);
	
	printf("\n%d-----%d ---------", vertical_level,*verticalSum);

	
	///return verticalSum;

}


//Function to return sum of a binary tree in vertical order
void findVerticalSum(struct node *r){
	if (r == NULL){
		return;
	}
	
	int min=0, max=0;
	findMinMax(r, &min, &max, 0);
	
	
	int i;
	for (i = min; i <= max; i++){
		printf("\n");
		int sum = 0;
		findVerticalLevelSum(r, i, 0, &sum);
	    //printf("\nSum at vertical level %d is : %d", i, a);

	}
	
}


//Function to check if the tree has children sum property
bool hasSumProperty(struct node *r){
	if (r == NULL || (r->left == NULL && r->right == NULL)){
		return (1 == 1);
	}
	
	bool a = 1;
	bool b = 1;
	
	a = hasSumProperty(r->left);
	b = hasSumProperty(r->right);
	
	int leftVal = r->left->data;
	int rightVal = r->right->data;
	
	if (r->left == NULL){
		leftVal = 0;
	}
	if (r->right == NULL){
		rightVal = 0;
	}
	
	if (r->data != (leftVal + rightVal)){
		return (1 == 0);
	}
	
	return (a & b);
}


//Function to convert a Binary Tree into a tree that holds Children Sum Property
void convertTree(struct node *r){
	
	if (r == NULL || (r->left == NULL && r->right == NULL)){
		return;
	}
	else {
		int leftVal = 0, rightVal = 0;
	
		convertTree(r->left);
		convertTree(r->right);
	
		if (r->left == NULL){
			leftVal = 0;
		}
		else {
			
			leftVal = r->left->data;
		}
	
		if (r->right == NULL){
			rightVal = 0;
		}
		else {
			rightVal = r->right->data;
		}
	
		r->data = leftVal + rightVal;
	}
}


//Function that returns the number of leaf nodes
int findNumberOfLeafNodes(struct node *r){
	if (r == NULL){
		return 0;
	}
	
	if (r->left == NULL && r->right == NULL){
		return 1;
	}
	else {
		return (findNumberOfLeafNodes(r->left) + findNumberOfLeafNodes(r->right));
	}
}


int main(void) {
	
	struct node *root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	root->right->left = newNode(6);
	root->right->right = newNode(7);
	
	
	struct node *root1 = newNode(22);
	root1->left = newNode(9);
	root1->right = newNode(13);
	root1->left->left = newNode(4);
	root1->left->right = newNode(5);
	root1->right->left = newNode(6);
	root1->right->right = newNode(7);
	
	bool x;
	int a, b;
	struct node *temp = NULL;
	
	printf("PreOrder Traversal of the binary tree: \n");
	printPreOrder(root);
	
	/*deleteTree(root);
	root = NULL;
	printf("\nTree Deleted...\n");
	printPreOrder(root);*/
	
	//printf("\n\nTotal number of nodes in the tree : %d\n", count(root));
	//printf("\nHeight of the tree is %d\n", findTreeDepth(root));
	
	/*mirrorBinaryTree(root);
	printf("\nPreOrder Traversal of mirrored binary tree: \n");
	printPreOrder(root);*/
	
	//printPaths(root);
	
	//printf("\nLevel Order traversal of the binary tree : \n");
	//printLevelOrder(root);
	
	//printf("\nLevel Order traversal of the binary tree in Spiral form: \n");
	//printLevelOrderSpiral(root);
	
	//printf("\nThe number of leaf nodes is : %d", countLeafNodes(root));
	
	//printf("\nThe diameter of the tree is : %d", calculateDiameter(root));
	
	/*a = 8;
	if(hasPathSum(root, a)){
		printf("\nThe tree contains node-to-leaf sum as %d", a);
	}
	else {
		printf("\nThe tree does not contain any node-to-leaf sum as %d", a);
	}*/
	
	/*a = 4;
	b = 7;
	temp = findLCA(root, a, b);
	printf("\nThe Least Common Ancestor for %d and %d is : %d", a, b, temp->data);*/
	
	/*printf("\nThe Binary Tree representation in Vertical Order : ");
	printVertical(root);*/
	
	//findVerticalSum(root);
	
	/*if (hasSumProperty(root1)){
		printf("\nThe Binary Tree has children Sum property");
	}
	else {
		printf("\nThe Binary Tree does not have children Sum property");
	}*/
	
	/*convertTree(root);
	printf("\n");
	printPreOrder(root);*/
	
	/*a = findNumberOfLeafNodes(root);
	printf("\nThe number of leaf nodes in the Binary Tree is : %d", a);*/
	
	return 0;
}
