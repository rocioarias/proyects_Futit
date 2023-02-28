var matrix1 = [[1, 0, 0], [0, 2, 0], [0, 0, 3]];
var matrix2 = [[1, 0, 0], [0, 2, 3], [0, 0, 3]];

function matrixDiagonal(matrix){
    var r = matrix.length;
    var c = matrix[0].length;

    //Set the result as false.
    var result = false;

    //Check if is an square, if this doesn't happen, is not diagonal.
    if(r == c){
        let subMatrix;
        /*
        *   After that, we have to see if we add all the numbers in the row, is the same number as the
        *   one in the diagonal (that means two things: all the others numbers are gonna be zero and
        *   the only number in the row is the one in the diagonal). 
        */
        for (let index = 0; index < r; index++) {
            subMatrix = matrix[index];
            let number = subMatrix.reduce((a, b) => a + b, 0);
            result = (number == subMatrix[index]);

            /*
            *   If one of the rows is not following the diagonal, the result is automatically false
            *   and the program gonna stop in that result.
            */
            if(!(result)){
                index = r;
            }
        }
    }
    return result;
}

console.log(matrixDiagonal(matrix1));
console.log(matrixDiagonal(matrix2));