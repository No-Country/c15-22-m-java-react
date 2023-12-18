import { useEffect, useState } from "react";
import { useContactoMascota } from "../../hooks/useContactoMascota";
import Layout from "../../ui/Layout";
import PetCard from "../components/PetCard";

export const HappyEndings = () => {
  const { pets, setpetPage } = useContactoMascota();
  const [happyEndings, setHappyEndings] = useState([]);

  useEffect(() => {
    if (pets.length > 0) {
      setHappyEndings(
        pets.filter((pet) => pet.state === "FOUND" || pet.state === "ADOPTED")
      );
    }
  }, [pets]);

  const renderHappyEndings = () => {
    if (happyEndings.length > 0) {
      return happyEndings.map((h) => <PetCard key={h.id} pet={h} />);
    }
  };

  useEffect(() => {
    setpetPage({});
  }, []);

  return (
    <Layout>
      <main className="max-w-screen-xl mx-auto p-4">
        <h1 className="text-4xl font-bold text-center mb-4">Finales Felices</h1>

        <div className="grid grid-cols-2 md:grid-cols-3 gap-4 my-4">
          {renderHappyEndings()}
        </div>
      </main>
    </Layout>
  );
};
