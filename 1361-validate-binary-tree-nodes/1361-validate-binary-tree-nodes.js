/**
 * @param {number} n
 * @param {number[]} leftChild
 * @param {number[]} rightChild
 * @return {boolean}
 */
var validateBinaryTreeNodes = function(n, leftChild, rightChild) {
    const par = Array.from({length: n}, (v, i) => i)
    let components = n

    const find = (node) => {
        if(par[node] !== node) par[node] = find(par[node])
        return par[node]
    }

    const union = (parent, child) => {
        let parentPar = find(parent), childPar = find(child)

        if(childPar !== child || parentPar === childPar) return false

        components--
        par[childPar] = parentPar
        return true
    }

    for(let node=0; node<n; node++){
        for(let child of [leftChild[node], rightChild[node]]){
            if(child === -1) continue
            if(!union(node, child)) return false

        }
    }

    return components === 1
};