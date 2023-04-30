#include <limits.h>
/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node struct is defined as follows:
	struct Node {
		int data;
		Node* left;
		Node* right;
	}
*/
	bool checkBST(Node* root) {
        if(root == NULL)
            return true;
        return check(root, INT_MIN, INT_MAX);
    }

    bool check(Node *root, int min, int max) {
        if(root == NULL)
            return true;
        if(root->data > min && root->data < max) {
            return (
                check(root->left, min, root->data) && check(root->right, root->data, max)
            );
        }
        return false;
    }