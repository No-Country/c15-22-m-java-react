import { useContactoMascota } from "../../hooks/useContactoMascota";
import Layout from "../../ui/Layout";
import imgcontactomascota from "../../../public/images/contactoMascota.png";
import PetCard from "../components/PetCard";
import { Link } from "react-router-dom";

export const DashboardPage = () => {
  const { petsOfUser } = useContactoMascota();

  return (
    <Layout>
      <main className="max-w-[1200px] mx-auto bg-orange">
        <h1 className="text-3xl md:text-5xl font-bold text-center py-6">
          Mi Dashboard
        </h1>
        <Link
          to={"/auth/reportarmascota"}
          className="text-white mb-4 inline-block bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-800"
        >
          Reportar mascota
        </Link>

        <h2 className="text-xl md:text-3xl font-bold text-left">
          Mis mascotas reportadas
        </h2>
        <div className="grid gap-10 justify-center grid-cols-[repeat(auto-fit,_260px)] max-w-[1240px] mx-auto items-center">
          {petsOfUser.length > 0
           /* petsOfUser.map((pet) => <PetCard key={pet.name} pet={pet} />) */ ? null : (
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