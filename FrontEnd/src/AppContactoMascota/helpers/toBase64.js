export const toBase64 = (file, callback) => {

    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {

        callback(reader.result);
    };

    reader.onerror = (error) => {
        console.log(error);
    }

}



