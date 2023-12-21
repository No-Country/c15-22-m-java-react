import ContactoMascotaProvider from "./context/ContactoMascotaProvider";
import { AppRouter } from "./router/AppRouter";

function App() {
  
  return (
    <>
      <ContactoMascotaProvider>
        <AppRouter />
      </ContactoMascotaProvider>
    </>
  );
}

export default App;
