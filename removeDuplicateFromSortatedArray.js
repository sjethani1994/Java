function removeDuplicate() {
  var sampleArray = [2, 4, 6, 4, 8, 2, 10, 6, 12];
  var uniqueArray = [];
  var duplicateValues = [];
  for (let i = 0; i < sampleArray.length; i++) {
    if (uniqueArray.indexOf(sampleArray[i]) === -1) {
      uniqueArray.push(sampleArray[i]);
    } else {
      duplicateValues.push(sampleArray[i]);
    }
  }

  console.log(uniqueArray);
  console.log(duplicateValues);
}

removeDuplicate();
