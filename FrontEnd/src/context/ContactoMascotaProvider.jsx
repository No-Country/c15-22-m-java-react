import { createContext, useEffect, useState } from "react";

const ContactoMascotaContext = createContext();

const ContactoMascotaProvider = ({ children }) => {
  const [mascotasperdidas, setMascotasPerdidas] = useState([]);
  const [happyEndings, setHappyEndings] = useState([]);

  const getHappyEndings = async () => {
    try {
      const res = await fetch(import.meta.env.VITE_API_URL);
      const data = await res.json();
      setHappyEndings(data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getHappyEndings();
  }, []);

  return (
    <ContactoMascotaContext.Provider value={{ mascotasperdidas, happyEndings }}>
      {children}
    </ContactoMascotaContext.Provider>
  );
};

export { ContactoMascotaContext };

export default ContactoMascotaProvider;
