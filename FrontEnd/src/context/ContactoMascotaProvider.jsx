import { createContext, useEffect, useState } from "react";

const ContactoMascotaContext = createContext();

const ContactoMascotaProvider = ({ children }) => {
  const [pets, setPets] = useState([]);
  const [happyEndings, setHappyEndings] = useState([]);

  const getPets = async () => {
    let requestOptions = {
      method: "GET",
      redirect: "follow",
    };
    const url = `${
      import.meta.env.VITE_API_BACKEND
    }/api/v1/pets?size10&page=0&sort=name,asc`;
    try {
      const res = await fetch(url, requestOptions);
      console.log(res);
      //const data = await res.json();
    } catch (error) {}
  };

  const getHappyEndings = async () => {
    try {
      const res = await fetch(import.meta.env.VITE_API_URL);
      const data = await res.json();
      console.log(data);
      setHappyEndings(data);
    } catch (error) {}
  };

  useEffect(() => {
    getHappyEndings();
    getPets();
  }, []);

  return (
    <ContactoMascotaContext.Provider value={{ happyEndings, pets }}>
      {children}
    </ContactoMascotaContext.Provider>
  );
};

export { ContactoMascotaContext };

export default ContactoMascotaProvider;
