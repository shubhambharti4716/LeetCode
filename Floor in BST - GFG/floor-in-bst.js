//{ Driver Code Starts
//Initial Template for javascript

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

class Node {
    constructor(data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}



function insert(tree, val) {
    if (tree === null) return new Node(val);
    
    if (val < tree.data) {
        tree.left = insert(tree.left, val);
    } else if (val > tree.data) {
        tree.right = insert(tree.right, val);
    }

    return tree;
}

function main() {
    const t = parseInt(readLine());
    for(let i = 0; i < t; i++) {
        let root = null;

        const n = parseInt(readLine());
        const elements = readLine().split(' ').map(Number);

        for (const el of elements) {
            root = insert(root, el);
        }

        const s = parseInt(readLine());
        
        console.log(floor(root, s));
    }
}



// } Driver Code Ends
//User function Template for javascript
function floor(root, x) {
    //code here
    let fl = -1;  // Variable to store the floor value, initialized as -1.

    // Traverse the BST until we reach a leaf node or find the target node.
    while (root) {
        if (root.data === x) {
            return root.data;  // If the current node value matches the target, return the target value.
        }

        if (root.data < x) {
            fl = root.data;  // If the current node value is less than the target, update the floor value.
            root = root.right;  // Move to the right subtree.
        } else {
            root = root.left;  // If the current node value is greater than or equal to the target, move to the left subtree.
        }
    }
    return fl;  // Return the floor value.
}

//{ Driver Code Starts.
// } Driver Code Ends