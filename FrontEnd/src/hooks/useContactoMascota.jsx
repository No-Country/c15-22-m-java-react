import { useContext } from "react";
import { ContactoMascotaContext } from "../context/ContactoMascotaProvider";

export const useContactoMascota = () => {
  return useContext(ContactoMascotaContext);
};





