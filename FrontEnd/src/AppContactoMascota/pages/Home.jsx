import Layout from "../../ui/Layout";
import Banner from "../components/Banner"
import PetCard from "../components/PetCard";
import Testimonial from "../components/Testimonial";

export const Home = () => {
  return (
    <Layout>
      
      <Banner/>

      <Testimonial/>
      <PetCard />
      
    </Layout>
  );
};
