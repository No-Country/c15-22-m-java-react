import { useContactoMascota } from "../../hooks/useContactoMascota";
import PetCard from "./PetCard";

const ListPets = () => {
  const { pets } = useContactoMascota();

  return (
    <main className="bg-orange-100 py-6">
      <h1 className="text-5xl font-bold text-center mb-5">Mascotas</h1>
      <section className="grid gap-6 justify-between m-0 grid-cols-[repeat(auto-fit,_260px)] max-w-[1200px] mx-auto bg-orange">
        {pets.map((pet) => (
          <PetCard key={pet.id} pet={pet} />
        ))}
      </section>
    </main>
  );
};

export default ListPets;
