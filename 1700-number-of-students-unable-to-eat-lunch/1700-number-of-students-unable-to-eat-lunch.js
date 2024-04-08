/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
var countStudents = function(students, sandwiches) {
    let studentsList = students, sandwichesList = sandwiches;

    while (sandwichesList) {
        let iterations = 0;
        while (studentsList) {
            if (sandwichesList[0] === studentsList[0]) {
                sandwichesList.shift();
                studentsList.shift();
                // console.log('break');
                // console.log(studentsList);
                // console.log(sandwichesList);
                iterations = 0;
                if (sandwichesList.length === 0 || studentsList.length === 0) return studentsList.length;
                break;
            } else {
                let shiftedStudent = studentsList.shift();
                studentsList.push(shiftedStudent);
                iterations++;
                // console.log(`'iteration++ = ${iterations}`);
                // console.log(studentsList);
                // console.log(sandwichesList);
            }
            if (iterations === studentsList.length) {
                // console.log('iteration = list length');
                // console.log(studentsList);
                // console.log(sandwichesList);
                return studentsList.length
            };
        }
    }
};