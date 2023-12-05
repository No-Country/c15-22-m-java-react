import { Layout } from "./AppContactoMascota/components";
import { HappyEndings } from "./AppContactoMascota/pages";
import Home from "./AppContactoMascota/pages/Home";
import { Routes, Route, Navigate } from "react-router-dom";
import Login from "./components/Login";


function App() {

  return (
    <>
       <Routes>
       <Route path="/auth/login" element={<Login />} />

      <Route path="/" element={<Layout />} />
      <Route path="/" index element={<Home />} />
      <Route path="/finalesfelices" element={<HappyEndings />} />
      <Route path="/*" element={<Navigate to="/" />} />
    </Routes>
    </>
  );
}

export default App;
