import { useContactoMascota } from "../../hooks/useContactoMascota";
import Layout from "../../ui/Layout";
import imgcontactomascota from "/images/contactoMascota.png";
import MyPetsCard from "../components/MyPetsCard";
import { Link } from "react-router-dom";
import { useEffect } from "react";

export const DashboardPage = () => {
  const { petsOfUser, setpetPage } = useContactoMascota();

  useEffect(() => {
    setpetPage({});
  }, []);

  return (
    <Layout>
      <main className="max-w-screen-xl mx-auto px-6">
        <h1 className="text-3xl md:text-5xl font-bold text-center py-6">
          Mi Dashboard
        </h1>
        <Link
          to={"/auth/reportarmascota"}
          className="text-white mb-4 inline-block bg-orange-500 hover:bg-orange-600 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-800"
        >
          Reportar mascota
        </Link>

        <h2 className="text-xl md:text-3xl font-bold text-left">
          Mis mascotas reportadas
        </h2>
        <div className="grid gap-6 justify-center my-4 grid-cols-[repeat(auto-fit,_260px)] max-w-[1200px] mx-auto">
          {petsOfUser.length > 0 ? (
            petsOfUser.map((pet) => <MyPetsCard key={pet.id} pet={pet} />)
          ) : (
            <div className="my-4">
              <img
                src={imgcontactomascota}
                width="auto"
                height="auto"
                alt="contacto mascota"
              />
              <p className="text-center">Aún no tienes mascotas reportadas</p>
            </div>
          )}
        </div>
      </main>
    </Layout>
  );
};
