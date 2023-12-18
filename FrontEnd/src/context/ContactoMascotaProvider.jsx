import { createContext, useEffect, useState } from "react";

const ContactoMascotaContext = createContext();

const ContactoMascotaProvider = ({ children }) => {
  const [pets, setPets] = useState([]);
  const [happyEndings, setHappyEndings] = useState([]);
  const [isLoginOpen, setIsLoginOpen] = useState(false);
  const [user, setUser] = useState({});
  const [lastPets, setLastPets] = useState([]);

  const getPets = async () => {
    const url = `${
      import.meta.env.VITE_API_BACKEND
    }/api/v1/pets?size10&page=0&sort=name,asc`;
    try {
      const res = await fetch(url);
      const data = await res.json();
      setPets(data.content);
    } catch (error) {}
  };

  const getLastPets = async () => {
    try {
      const url = `${import.meta.env.VITE_API_BACKEND}/api/v1/pets`;
      const res = await fetch(url);
      const data = await res.json();
      setLastPets(data.content.slice(-3));
    } catch (error) {
      console.error(error);
    }
  };

  const getHappyEndings = async () => {
    try {
      const res = await fetch(import.meta.env.VITE_API_URL);
      const data = await res.json();
      setHappyEndings(data);
    } catch (error) {}
  };

  const getUser = async () => {
    try {
      let {
        state: {
          user: { token },
        },
      } = JSON.parse(localStorage.getItem("userInfo"));

      if (!token) {
        throw new Error("No se pudo obtener el token del usuario.");
      }
      let url = `${import.meta.env.VITE_API_BACKEND}/user/profile`;

      let myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      let requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      const res = await fetch(url, requestOptions);
      const data = await res.json();
      setUser(data);
    } catch (error) {
      console.error(error);
    }
  };

  const reportPet = async (form) => {
    try {
      let {
        state: {
          user: { token },
        },
      } = JSON.parse(localStorage.getItem("userInfo"));

      if (!token) {
        throw new Error("No se pudo obtener el token del usuario.");
      }

      let url = `${import.meta.env.VITE_API_BACKEND}/api/v1/pet`;

      const res = await fetch(url, {
        method: "post",
        body: JSON.stringify(form),
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      });

      const data = await res.json();
      console.log(data);
    } catch (error) {
      console.error(error);
    }
  };

  const openLoginModal = () => {
    setIsLoginOpen(true);
  };

  const closeLoginModal = () => {
    setIsLoginOpen(false);
  };

  useEffect(() => {
    getHappyEndings();
    getPets();
    getLastPets();
  }, [pets]);

  useEffect(() => {
    let datauser = JSON.parse(localStorage.getItem("userInfo"));
    if (Object.values(datauser).length > 0) {
      getUser();
    }
  }, []);

  return (
    <ContactoMascotaContext.Provider
      value={{
        happyEndings,
        isLoginOpen,
        openLoginModal,
        closeLoginModal,
        pets,
        user,
        reportPet,
        lastPets,
      }}
    >
      {children}
    </ContactoMascotaContext.Provider>
  );
};

export { ContactoMascotaContext };

export default ContactoMascotaProvider;
