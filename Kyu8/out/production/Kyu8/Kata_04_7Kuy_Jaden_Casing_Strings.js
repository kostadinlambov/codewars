String.prototype.toJadenCase = function () {
    console.log("in");
    console.log('this: ', this);
    console.log(arguments[0]);

    function capitalizeFirstLetter(string) {
        return string.charAt(0).toUpperCase() + string.slice(1);
    }
    return this.split(' ').map(x => capitalizeFirstLetter(x)).join(' ');
};

console.log("How can mirrors be real if our eyes aren't real".toJadenCase());
