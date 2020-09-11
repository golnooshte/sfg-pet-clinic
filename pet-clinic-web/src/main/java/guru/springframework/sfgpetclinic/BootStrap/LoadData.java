package guru.springframework.sfgpetclinic.BootStrap;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.model.vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class LoadData implements CommandLineRunner{
    private  final OwnerService ownerService;
    private  final VetService vetService;
    private final PetTypeService petTypeServices;

    public LoadData(OwnerService ownerService, VetService vetService, PetTypeService PetTypeService ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeServices = PetTypeService;
    }
    @Override
    public void run(String... args) throws Exception {
        PetType cat=new PetType();
        cat.setName("cat");
        PetType catSave=petTypeServices.save(cat);

        PetType dog=new PetType();
        dog.setName("dog");
        PetType dogsave=petTypeServices.save(dog);



        owner owner1= new owner();
        owner1.setId(1L);
        owner1.setFirstName("Goli");
        owner1.setLastName("Teymouri");
        owner1.setAddress("Kesklinn 10151");
        owner1.setCity("Tallin");
        owner1.setPhone("37255979514");

        Pet pet1=new Pet();
        pet1.setName("Dorry");
        pet1.setBirthday(LocalDate.now());
        pet1.setOwner(owner1);
        pet1.setPetType(dogsave);

        owner1.getPets().add(pet1);

        Pet pet2=new Pet();
        pet2.setName("hope");
        pet2.setBirthday(LocalDate.now());
        pet2.setOwner(owner1);
        pet2.setPetType(catSave);

        owner1.getPets().add(pet2);
        ownerService.save(owner1);


        owner owner2= new owner();
        owner2.setFirstName("mahdi");
        owner2.setLastName("Karaz");
        owner2.setAddress("Manaee p 1");
        owner2.setCity("Tehran");
        owner2.setPhone("09125867140");

        ownerService.save(owner2);





        vet vet1=new vet();

        vet1.setFirstName("misha");
        vet1.setLastName("rohani");
        this.vetService.save(vet1);

        vet vet2=new vet();
        vet2.setId(2L);
        vet2.setFirstName("maryam");
        vet2.setLastName("asghari");
        this.vetService.save(vet2);
        System.out.println("Loading vets");
    }
}
