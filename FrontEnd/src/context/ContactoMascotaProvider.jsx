import { createContext, useState, useContext } from "react";

const ContactoMascotaContext = createContext();

const ContactoMascotaProvider = ({ children }) => {
  const [mascotasperdidas, setMascotasPerdidas] = useState([]);
  
  const [isLoginOpen, setIsLoginOpen] = useState(false);

  const openLoginModal = () => {
    setIsLoginOpen(true);
  };

  const closeLoginModal = () => {
    setIsLoginOpen(false);
  };

  return (
    <ContactoMascotaContext.Provider value={{ mascotasperdidas, isLoginOpen, openLoginModal, closeLoginModal }}>
      {children}
    </ContactoMascotaContext.Provider>
  );
};

export { ContactoMascotaContext };

export default ContactoMascotaProvider;
