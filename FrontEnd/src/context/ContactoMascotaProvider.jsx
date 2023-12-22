import { createContext, useEffect, useState } from "react";

const ContactoMascotaContext = createContext();

const ContactoMascotaProvider = ({ children }) => {
  const [pets, setPets] = useState([]);
  const [isLoginOpen, setIsLoginOpen] = useState(false);
  const [user, setUser] = useState({});
  const [lastPets, setLastPets] = useState([]);
  const [petsOfUser, setPetsOfUser] = useState([]);
  const [petPage, setpetPage] = useState({});
  const [petActive, setPetActive] = useState({});
  const [imagePet, setImagePet] = useState({});

  const getPets = async () => {
    const url = `${
      import.meta.env.VITE_API_BACKEND
    }/api/v1/pets?size10&page=0&sort=id,asc`;
    try {
      const res = await fetch(url);
      const data = await res.json();
      setPets(data.content);
      setpetPage({});
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

  const getPet = async (id) => {
    try {
      const url = `${import.meta.env.VITE_API_BACKEND}/api/v1/pet/${id}`;
      const res = await fetch(url);
      const data = await res.json();
      setpetPage(data);
    } catch (error) {
      console.error(error);
    }
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
      setPetsOfUser(data.pets);
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
      setPets([...pets, data]);
      getUser();
      setpetPage({});
    } catch (error) {
      console.error(error);
    }
  };

  const updateImagePet = async (image, id) => {
    try {
      let {
        state: {
          user: { token },
        },
      } = JSON.parse(localStorage.getItem("userInfo"));

      if (!token) {
        throw new Error("No se pudo obtener el token del usuario.");
      }

      let url = `${import.meta.env.VITE_API_BACKEND}/api/v1/image/${id}`;

      const res = await fetch(url, {
        method: "put",
        body: JSON.stringify({ imageBase64: image }),
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      });

      const data = await res.json();
      console.log(data);
      getUser();
    } catch (error) {
      console.error(error);
    }
  };

  const onUpdatePet = async (form) => {
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
        method: "put",
        body: JSON.stringify(form),
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      });

      if (!form.image.imageBase64) {
        updateImagePet(form.image, imagePet?.image_id);
      }

      const data = await res.json();
      data.image = form.image;

      let updatePets = pets.map((pet) => {
        if (pet.id === data.id) {
          return data;
        }
        return pet;
      });

      setPets(updatePets);
      getUser();
      setpetPage({});
    } catch (error) {
      console.error(error);
    }
  };

  const onDeletePet = async (id) => {
    try {
      setLastPets(lastPets.filter((pet) => pet.id !== id));
      setPets(pets.filter((pet) => pet.id !== id));
      setPetsOfUser(petsOfUser.filter((pet) => pet.id !== id));
      let {
        state: {
          user: { token },
        },
      } = JSON.parse(localStorage.getItem("userInfo"));

      if (!token) {
        throw new Error("No se pudo obtener el token del usuario.");
      }

      let url = `${import.meta.env.VITE_API_BACKEND}/api/v1/pet/${id}`;

      const res = await fetch(url, {
        method: "delete",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      });

      await res.json();
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
    getPets();
  }, []);

  useEffect(() => {
    getLastPets();
  }, [pets]);

  return (
    <ContactoMascotaContext.Provider
      value={{
        isLoginOpen,
        openLoginModal,
        closeLoginModal,
        pets,
        user,
        reportPet,
        lastPets,
        petsOfUser,
        getPet,
        petPage,
        setpetPage,
        onDeletePet,
        petActive,
        setPetActive,
        onUpdatePet,
        setImagePet,
        setUser,
        getUser,
      }}
    >
      {children}
    </ContactoMascotaContext.Provider>
  );
};

export { ContactoMascotaContext };

export default ContactoMascotaProvider;
