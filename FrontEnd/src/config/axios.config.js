import axios from "axios";

const axiosMascota = axios.create({
  baseURL: "https://mascotas-i7v0.onrender.com",
});
export { axiosMascota };
