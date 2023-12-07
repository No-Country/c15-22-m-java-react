import { Routes, Route, Navigate } from "react-router-dom";
import { Home, HappyEndings } from "../pages";
import Login from "../components/Login";


export const MascotasRoutes = () => {
  return (
    <Routes>

      <Route path="/auth/login" element={<Login />} />
      <Route path="/" index element={<Home />} />
      <Route path="/finalesfelices" element={<HappyEndings />} />
      <Route path="/*" element={<Navigate to="/" />} />
    </Routes>
  );
};
