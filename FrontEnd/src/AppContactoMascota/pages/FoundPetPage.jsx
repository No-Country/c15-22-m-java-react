import { useEffect, useState } from "react";
import { useContactoMascota } from "../../hooks/useContactoMascota";
import Layout from "../../ui/Layout";
import PetCard from "../components/PetCard";

export const FoundPetPage = () => {
  const { pets, setpetPage } = useContactoMascota();
  const [foundPets, setFoundPets] = useState([]);

  useEffect(() => {
    if (pets.length > 0) {
      setFoundPets(pets.filter((pet) => pet.state === "FOUND"));
    }
  }, [pets]);

  const renderFoundPets = () => {
    return foundPets.map((pet) => <PetCard key={pet.id} pet={pet} />);
  };

  useEffect(() => {
    setpetPage({});
  }, []);

  return (
    <Layout>
      <main className="max-w-screen-xl mx-auto">
        <h1 className="text-3xl md:text-5xl font-bold text-center py-6">
          Mascotas encontradas
        </h1>
        <section className="grid gap-6 justify-center m-0 grid-cols-[repeat(auto-fit,_260px)] max-w-[1200px] mx-auto mb-8">
          {renderFoundPets()}
        </section>
      </main>
    </Layout>
  );
};
