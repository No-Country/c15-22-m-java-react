export const getImageOfBase64 = (base64String, callback) => {
    let img = new Image();

    img.onload = () => {
        callback(img.src);
    }

    img.src = "data:image/jpeg;base64," + base64String;

}
