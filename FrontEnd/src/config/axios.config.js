import axios from "axios";

const axiosMascota = axios.create({
  baseURL: "http://191.96.251.43:8181",
});
export { axiosMascota };
