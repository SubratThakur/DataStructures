#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Binary Search Tree ADT Implementation

/*	Includes the following functions:
	01. Function to insert a new node in the BST
	02. Function to print the in order traversal of BST
	03. Function to find minimum key in BST
	04. Function to find maximum key in BST
	05. Function to search a key in the BST
	06. Function to get the inorder successor for a given key in the BST
	07. Function to get the inorder predecessor for a given key in the BST
	08. Function to find the Lowest Common Ancestor in a BST
	09. Function that returns true if the given keys are siblings in the BST
	10. Function that prints keys with no siblings in the BST
	11. Function to get the level of a key in Binary Tree
	12. Function that returns true if the given keys are cousins in the BST
	13. Function to find distance of a key from a given ancestor
	14. Function to find distance between two nodes in BST
*/

struct node {
	int key;
	struct node *left, *right;
};

// Utility function to create a new BST node
struct node *createNode(int data){
	
	struct node *temp = (struct node *)malloc(sizeof(struct node));
	temp->left = temp->right = NULL;
	temp->key = data;
	
	return temp;
}

// Function to insert a new node in the BST
struct node *insertNode(struct node *r, int key){
	
	if(r==NULL){
		return createNode(key);
	}
	
	if(key<r->key){
		r->left=insertNode(r->left, key);
	}
	else{
		r->right=insertNode(r->right, key);
	}
	
	return r;
}

// Function to print InOrder traversal of BST
void printInOrder(struct node *r){
	if(r==NULL){
		return;
	}
	
	printInOrder(r->left);
	printf("%d\t", r->key);
	printInOrder(r->right);
}


// Function to find the minimum key in the BST
struct node *findMinimum(struct node *r){
	
	while(r->left!=NULL){
		r = r->left;
	}
	
	return r;
}


// Function to find the maximum key in the BST
struct node *findMaximum(struct node *r){
	if(!r){
		return NULL;
	}
	
	while(r->right){
		r = r->right;
	}
	
	return r;
}

// Function to search key in BST
struct node *searchBST(struct node *r, int key){
	if(r==NULL)
		return NULL;
		
	if(r->key==key){
		return r;
	}
	
	if(r->key>key){
		return searchBST(r->left, key);
	}
	else{
		return searchBST(r->right, key);
	}
	
	return NULL;
}

// Function to get the inorder successor for a given key in the BST
struct node *inorderSuccessor(struct node *r, int key){
	struct node *successor = NULL;
	struct node *current = r;
	
	if (!r){
		return NULL;
	}
	
	while(current->key != key){
		
		if(current->key > key){
			successor = current;
			current = current->left;
		}
		else {
			current = current->right;
		}
	}
	
	if(current && current->right){
		successor = findMinimum(current->right);
	}
	
	return successor;
}

// Function to get the inorder predecessor for a given key in the BST
struct node * inorderPredecessor(struct node *r, int key){
	struct node * predecessor = NULL;
	
	while(r->key != key){
		if(r->key > key){
			r = r->left;
		}
		else {
			predecessor = r;
			r = r->right;
		}
	}
	
	if(r && r->left){
		predecessor = findMaximum(r->left);
	}
	
	return predecessor;
}

// Function to get the inorder predecessor and successor for a given key in BST
// In case the given key is not found, function returns the two values within which the key will lie
/*void findPreSucBST(struct node *r, struct node **pre, struct node **suc, int key){
	
	if(r==NULL){
		return;
	}
	
	//if key is present at root
	if(r->key==key){
		
		//maximum value in left subtree is predecessor
		if(r->left!=NULL){
			struct node *temp = r->left;
			while (temp->right){
				temp = temp->right;
			}
			*pre = temp;
		}
		
		//minimum value in right subtree is successor
		if(r->right!=NULL){
			struct node *temp = r->right;
			while(temp->left){
				temp = temp->left;
			}
			*suc = temp;
		}
		
		return;
	}
	
	//if the key is smaller than root key, then go to the left subtree
	if(r->key > key){
		*suc = r;
		findPreSucBST(r->left, &pre, &suc, key);
	}
	else {
		*pre = r;
		findPreSucBST(r->right, &pre, &suc, key);
	}
}*/

//Function to find the Lowest Common Ancestor in a BST
//If the key is nt present in the BST, findLCA returns the value
//that would have been returned, had the keys been in the BST
struct node *findLCA(struct node *r, int a, int b){
	if (r == NULL){
		return NULL;
	}
	
	if (r->key > a && r->key > b){
		return findLCA(r->left, a, b);
	}
	else if(r->key < a && r->key < b){
		return findLCA(r->right, a, b);
	}
	
	return r;
}


// Helper function for findkthSmallest
struct node *findkthSmallestKey (struct node *r, int k){
	if(r == NULL){
		return NULL;
	}
	
	findkthSmallestKey(r->left, k);
	
	if(k == 0){
		return r;
	}
	
	k--;
	findkthSmallestKey(r->right, k);
	
}


// Function to find kth smallest key in the BST
struct node * findkthSmallest(struct node *r, int k){
	int x = 0;
	x = k-1;
	
	return findkthSmallestKey(r, x);
	
}


//Function that returns true if the given keys are siblings in the BST
bool isSibling(struct node *r, int a, int b){
	if(r == NULL) {
		return (0 == 1);
	}
	
	if (r->left == NULL || r->right == NULL){
		return (1 == 0);
	}

	return ((r->left->key == a && r->right->key == b) || (r->left->key == b && r->right->key == a) 
	|| isSibling(r->left, a, b) || isSibling(r->right, a, b)
	);

}


//Function that prints keys with no siblings in the BST
void printSingleChild(struct node *r){
	if (r == NULL){
		return;
	}
	
	if (r->left != NULL && r->right == NULL){
		printf("%d\t", r->left->key);
	}
	
	if (r->right != NULL && r->left == NULL){
		printf("%d\t", r->right->key);
	}
	
	printSingleChild(r->left);
	printSingleChild(r->right);
	
}


//Utility function for getLevel
int getLevelUtil(struct node *r, int key, int level){
	if (r == NULL){
		return 0;
	}
	
	if(r->key == key){
		return level;
	}
	
	int downLevel = getLevelUtil(r->left, key, level+1);
	if (downLevel != 0){
		return downLevel;
	}
	
	downLevel = getLevelUtil(r->right, key, level+1);
	return downLevel;
}


//Function to get the level of a key in Binary Tree
int getLevel(struct node *r, int key){
	if (r == NULL){
		return 0;
	}
	
	return getLevelUtil(r, key, 1);
}


//Function that returns true if the given keys are cousins in the BST
bool isCousin(struct node *r, int a, int b){
	if (r == NULL){
		return (1 == 0);
	}
	
	return ((getLevel(r, a) == getLevel(r, b)) && !(isSibling(r, a, b)));
}


//Function to find distance of a key from a given ancestor
int findDistanceFromAncestor(struct node *ancestor, int key){
	if (ancestor == NULL){
		return 0;
	}
	
	int distanceFromAncestor = 0;
	struct node *temp = ancestor;
	
	while(temp->key != key){
		
		if(temp->key > key){
			temp = temp->left;
		}
		else if(temp->key < key){
			temp = temp->right;
		}
		
		distanceFromAncestor++;
	}
	return distanceFromAncestor;
}


//Function to find distance between two nodes in BST
//Based on the assumption that the two keys are present in the BST
int getDistanceBetweenKeys(struct node *r, int a, int b){
	if (r == NULL){
		return 0;
	}
	
	struct node *lca = findLCA(r, a, b);
	return (findDistanceFromAncestor(lca, a) + findDistanceFromAncestor(lca, b));
}



int main(void) {
	
	struct node *root, *min=NULL;
	struct node *pre, *suc, *temp = NULL;
	int key, a, b;
	
	/*
					50
			25				60
		13		26		55		65	
	*/
	root=insertNode(root, 50);
	insertNode(root,25);
	insertNode(root, 60);
	insertNode(root, 13);
	insertNode(root, 26);
	insertNode(root, 55);
	insertNode(root, 65);
	
	printf("Inorder traversal of the BST : \n");
	printInOrder(root);
	
	min = findMinimum(root);
	//printf("\nThe minimum key in the BST is : %d", min->key);
	
	/*key = 25;
	if(searchBST(root, key))
		printf("\nKey found in the BST.\n");
	else
		printf("\nKey doesnot exist in the BST.\n");*/
	
	/*key = 65;	
	findPreSucBST(root, &pre, &suc, key);
	if(pre!=NULL)
		printf("\nThe predecessor for the key is : %d", pre->key);
	else
		printf("\nNo Predecessor.");
	if(suc!=NULL)
		printf("\nThe successor for the key is : %d", suc->key);
	else
		printf("\nNo Successor.");*/
		
	/*key = 65;
	suc = inorderSuccessor(root, key);
	pre = inorderPredecessor(root, key);
	
	if(pre!=NULL)
		printf("\nThe predecessor for the key is : %d", pre->key);
	else{
		printf("\nNo Predecessor.");
	}
	
	if(suc!=NULL)
		printf("\nThe successor for the key is : %d", suc->key);
	else{
		printf("\nNo Successor.");
	}*/
	
	/*a = 15;
	b = 65;
	temp = findLCA(root, a, b);
	printf("\nThe Lowest Common Ancestor of %d and %d is : %d", a, b, temp->key);*/
	
	/*a = 13;
	b = 26;
	if (isSibling(root, a, b)){
		printf("\nThe keys %d and %d are siblings in the BST.", a, b);
	}
	else {
		printf("\nThe keys %d and %d are not siblings in the BST.", a, b);
	}*/
	
	/*printf("\nFollowing are the keys that have no siblings: \n");
	printSingleChild(root);*/
	
	/*a = 60;
	printf("\nThe level for %d in the Binary Tree is : %d", a, getLevel(root, a));*/
	
	/*a = 50;
	b = 60;
	if (isCousin(root, a, b)){
		printf("\nThe keys %d and %d are cousins in the BST.", a, b);
	}
	else {
		printf("\nThe keys %d and %d are not cousins in the BST.", a, b);
	}*/
	
	/*a = 55;
	printf("\nDistance of %d from the root is : %d", a, findDistanceFromAncestor(root, a));*/
	
	/*a = 13;
	b = 26;
	printf("\nDistance between the two keys %d and %d is : %d", a, b, getDistanceBetweenKeys(root, a, b));*/
	
	return 0;
}
