import { useState } from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import { MascotasRoutes } from "../AppContactoMascota/routes/MascotasRoutes";
import {
  FoundPetPage,
  HappyEndings,
  Home,
  LostPetPage,
} from "../AppContactoMascota/pages";
import { Layout } from "../AppContactoMascota/components";

export const AppRouter = () => {
  const [status, setStatus] = useState("authenticated");

  return (
    <Routes>
      {status === "not-authenticated" ? (
        <>
          <Route path="/*" element={<MascotasRoutes />} />
        </>
      ) : (
        <>
          <Route path="/" element={<Layout />} />
          <Route path="/" index element={<Home />} />
          <Route path="/finalesfelices" element={<HappyEndings />} />
          <Route path="/auth/mascotaencontrada" element={<FoundPetPage />} />
          <Route path="/auth/mascotaperdida" element={<LostPetPage />} />
          <Route path="/*" element={<Navigate to="/" />} />
        </>
      )}
    </Routes>
  );
};
