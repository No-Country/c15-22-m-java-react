import { createContext, useState } from "react";

const ContactoMascotaContext = createContext();

const ContactoMascotaProvider = ({ children }) => {
  const [mascotasperdidas, setMascotasPerdidas] = useState([]);

  return (
    <ContactoMascotaContext.Provider value={{ mascotasperdidas }}>
      {children}
    </ContactoMascotaContext.Provider>
  );
};

export { ContactoMascotaContext };

export default ContactoMascotaProvider;
