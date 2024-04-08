/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
 class QueueNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class Queues {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    enqueue(data) {
        let newNode = new QueueNode(data);

        if (this.tail === null) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        
        this.size++;
    }

    dequeue() {
        if (this.isEmpty()) {
            return null;
        }

        let removedNode = this.head;
        this.head = this.head.next;

        if (this.head === null) {
            this.tail = null;
        }

        this.size--;
        return removedNode.data;
    }

    isEmpty() {
        return this.size === 0;
    }

    peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.head.data;
    }

    getSize() {
        return this.size;
    }
}
var countStudents = function(students, sandwiches) {
    const len = students.length
    const studentsQueue = new Queues()
    const foodStack = new Array()

    for (let i = 0 ; i < len ; i++){
        studentsQueue.enqueue(students[i])
        foodStack.push(sandwiches[len - 1 - i])
    }

    let counter = 0
    while(counter<foodStack.length){
        if(studentsQueue.peek() == foodStack[foodStack.length - 1]){
            studentsQueue.dequeue()
            foodStack.pop()
            counter = 0
        }else{
            const deqVal = studentsQueue.dequeue()
            studentsQueue.enqueue(deqVal)
            counter++
        }
    }
    return counter
};