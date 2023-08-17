function moveZeros() {
   const array = [1, 0, 3, 0, 5];
   const resultArray = [];

   let zeroCount = 0;

   for (let i = 0; i < array.length; i++) {
      if (array[i] === 0) {
          zeroCount++;
      } else {
          resultArray.push(array[i]);
      }
   }

   // Add the zeros to the front of the array
   for (let i = 0; i < zeroCount; i++) {
      resultArray.unshift(0);
   }

   console.log(JSON.stringify(resultArray));
}

moveZeros();
