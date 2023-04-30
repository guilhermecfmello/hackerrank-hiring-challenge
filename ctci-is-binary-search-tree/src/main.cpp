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
        // bool result = checkLeft(root->left, root->data) && checkRight(root->right, root->data);
        // cout << "Result: " << result << "\n";
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

    bool checkLeft(Node *root, int value) {
        if(root == NULL) {
            return true;
        }
        // cout << "comparing if " << root->data << " < " << value << "\n";
        if(root->data < value)
            return (checkLeft(root->left, root->data) && checkRight(root->right, root->data));
        return false;
    }

    bool checkRight(Node *root, int value) {
        if(root == NULL) {
            return true;
        }
        // cout << "comparing if " << root->data << " > " << value << "\n";
        if(root->data > value)
            return (checkLeft(root->left, root->data) && checkRight(root->right, root->data));
        return false;
    }