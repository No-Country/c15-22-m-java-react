export const toBase64 = (file, callback) => {

    if (file === "") return;

    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {

        const base64String = reader.result.split(",")[1];
        callback(base64String);
    };

    reader.onerror = (error) => {
        console.log(error);
    }

}
