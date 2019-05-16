function createPhoneNumber(numbers){
    return `(${numbers[0]}${numbers[1]}${numbers[2]}) ${numbers[3]}${numbers[4]}${numbers[5]} - ${numbers[6]}${numbers[7]}${numbers[8]}${numbers[9]}`
  
    // Top Solutions from CodeWars
  
  //   return numbers.join('').replace(/(...)(...)(.*)/, '($1) $2-$3');
  }
  
module.exports.createPhoneNumber = createPhoneNumber;