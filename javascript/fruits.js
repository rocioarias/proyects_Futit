var list = ["Apple", "Orange", "Banana", "Strawberry", "Grape", "Mango", "Melon","Pineapple", "Peach", "Peach"];
    function findLetter(word){
        if (word.includes('p')){
            return word;
        }
    }
console.log(list.filter(findLetter));
// Result = [ “Apple”, “Grape”, “Pineapple” ]


//This only give the word Grape as an String
var findTheWordGrape = list.filter(word => word == "Grape");
console.log(findTheWordGrape.toString());