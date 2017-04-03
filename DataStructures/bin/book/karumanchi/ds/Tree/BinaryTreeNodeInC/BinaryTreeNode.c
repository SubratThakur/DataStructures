#include <stdio.h>
#include <stdlib.h>

// Binary Tree ADT implementation

struct node {
	int data;
	struct node *left;
	struct node *right;
};

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

int main(void) {
	
	struct node *root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	root->right->left = newNode(6);
	root->right->right = newNode(7);
	
	printf("PreOrder Traversal of the binary tree: \n");
	printPreOrder(root);
	
	printf("\n\nTotal number of nodes in the tree : %d\n", count(root));
	
	return 0;
}
