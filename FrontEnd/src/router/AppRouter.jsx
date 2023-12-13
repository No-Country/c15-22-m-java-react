
import { Routes, Route, Navigate } from "react-router-dom";

import {
  FoundPetPage,
  HappyEndings,
  Home,
  LostPetPage,
} from "../AppContactoMascota/pages";
import Login from "../AppContactoMascota/components/Login";
import Register from "../AppContactoMascota/components/Register";
import Page404 from "../AppContactoMascota/pages/Page404";
import PrivateRoutes from "../auth/PrivateRoutes";

export const AppRouter = () => {
  

  return (
    <Routes>
      <Route path="/auth/login" element={<Login />} />
      <Route path="/auth/register" element={<Register />} />

      <Route element={<PrivateRoutes />}>
        <Route path="/*" element={<Navigate to="/" />} />
        <Route path="/" index element={<Home />} />
        <Route path="/auth/mascotaencontrada" element={<FoundPetPage />} />
        <Route path="/auth/mascotaperdida" element={<LostPetPage />} />
        <Route path="/finalesfelices" element={<HappyEndings />} />
      </Route>

      <Route path="*" element={<Page404 />} />
    </Routes>
    // <Routes>
    //   {status === "not-authenticated" ? (
    //     <>
    //       <Route path="/*" element={<MascotasRoutes />} />

    //     </>
    //   ) : (
    //     <>
    //       <Route path="/auth/login" element={<Login />} />
    //       <Route path="/auth/register" element={<Register />} />

    //       <Route path="/" index element={<Home />} />
    //       <Route path="/finalesfelices" element={<HappyEndings />} />
    //       <Route path="/auth/mascotaencontrada" element={<FoundPetPage />} />
    //       <Route path="/auth/mascotaperdida" element={<LostPetPage />} />
    //       <Route path="/*" element={<Navigate to="/" />} />
    //     </>
    //   )}
    //   <Route path="*" element={<Page404 />} />
    // </Routes>
  );
};
