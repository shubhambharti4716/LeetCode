//{ Driver Code Starts
//Initial Template for javascript


'use strict';

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

class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

let head = null;

function findNode(head, search_for)
{
    let current = head;
    while (current !== null)
    {
        if (current.data == search_for)
            break;
        current = current.next;
    }
    return current;
}

function printlist(head){
    let current = head; 
    let s='';
    while (current !== null)
    {
        s+=current.data+" ";
        current = current.next;
    }
    console.log(s);
}


function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let n = parseInt(readLine());
        let input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        head = new Node(input_ar1[0]);
        let tail = head;
        for(let i=1;i<n;i++){
            tail.next = new Node(input_ar1[i]);
            tail = tail.next;
        }
        let data= parseInt(readLine());
        let obj = new Solution();
        let newHead = obj.sortedInsert(head, data);
        printlist(newHead);
        
    }
}


// } Driver Code Ends


//User function Template for javascript

/**
 * @param {Node} node
 * @param {number} data
 * @return {Node} node
*/


/*
class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

let head;
This is method only submission.
You only need to complete the below method.
*/

class Solution {
    sortedInsert(node, data)
    {
        let new_node = new Node(data);
        
        if (node == null || node.data >= new_node.data)
        {
            // if new node is needed at the start of list
            new_node.next = node;
            return new_node;
        }
        
        let current = node;
        while (current.next != null && current.next.data < new_node.data)
            current = current.next;
            // finding a node which has lesser value than new_node
            // but its successor should have greater (or equal) value
        
        // inserting new_node after current node
        new_node.next = current.next;
        current.next = new_node;
        
        return node;
    }
}
