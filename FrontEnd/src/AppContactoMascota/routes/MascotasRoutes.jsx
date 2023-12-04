import { Routes, Route, Navigate } from "react-router-dom";
import { Home, HappyEndings } from "../pages";
export const MascotasRoutes = () => {
  return (
    <Routes>
      <Route path="/" index element={<Home />} />
      <Route path="/finalesfelices" element={<HappyEndings />} />
      <Route path="/*" element={<Navigate to="/" />} />
    </Routes>
  );
};
