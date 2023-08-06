class HashMap {
  constructor() {
    this.map = new Map();
  }

  findIndicesOfTwoNumbers(weightsOfPackages, target) {
    for (let index = 0; index < weightsOfPackages.length; index++) {
      let diff = target - weightsOfPackages[index];
      if (this.map.has(diff)) {
        return [this.map.get(diff), index];
      }
      this.map.set(weightsOfPackages[index], index);
    }
    return [];
  }
}

const myMap = new HashMap();
let targetWeight = 10;
let weightsOfPackages = [4, 6, 2, 9, 7, 3];
let indices = myMap.findIndicesOfTwoNumbers(weightsOfPackages, targetWeight);

if (indices.length === 2) {
  let index1 = indices[0];
  let index2 = indices[1];
  console.log(index1 + " " + index2);
} else {
  console.log("No pair found.");
}
