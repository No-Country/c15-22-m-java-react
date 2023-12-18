import { useEffect, useState } from "react";
import { useContactoMascota } from "../../hooks/useContactoMascota";
import Layout from "../../ui/Layout";
import PetCard from "../components/PetCard";

export const LostPetPage = () => {
  const { pets, setpetPage } = useContactoMascota();
  const [lostPets, setLostPets] = useState([]);

  useEffect(() => {
    if (pets.length > 0) {
      setLostPets(pets.filter((pet) => pet.state === "LOST"));
    }
  }, [pets]);

  const renderLostPets = () => {
    return lostPets.map((pet) => <PetCard key={pet.id} pet={pet} />);
  };
  useEffect(() => {
    setpetPage({});
  }, []);

  return (
    <Layout>
      <main className="max-w-screen-xl mx-auto">
        <h1 className="text-3xl md:text-5xl font-bold text-center py-6">
          Mascotas perdidas
        </h1>
        <section className="grid gap-6 justify-center m-0 grid-cols-[repeat(auto-fit,_260px)] max-w-[1200px] mx-auto mb-8">
          {renderLostPets()}
        </section>
      </main>
    </Layout>
  );
};
