import { Routes, Route, Navigate } from "react-router-dom";
import { Layout } from "../components";
import { Home, HappyEndings } from "../pages";
export const MascotasRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Layout />} />
      <Route path="/" index element={<Home />} />
      <Route path="/finalesfelices" element={<HappyEndings />} />
      <Route path="/*" element={<Navigate to="/" />} />
    </Routes>
  );
};
