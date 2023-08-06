function productExceptSelf(nums) {
  const n = nums.length;
  const result = new Array(n).fill(1);

  // Calculate product of all elements to the left of each element
  let leftProduct = 1;
  for (let i = 0; i < n; i++) {
    result[i] *= leftProduct;
    leftProduct *= nums[i];
  }

  // Calculate product of all elements to the right of each element
  let rightProduct = 1;
  for (let i = n - 1; i >= 0; i--) {
    result[i] *= rightProduct;
    rightProduct *= nums[i];
  }

  return result;
}

// Example usage:
const arrayExample = [4, 3, 2, 1];
console.log(productExceptSelf(arrayExample)); // Output: [24, 12, 8, 6]
