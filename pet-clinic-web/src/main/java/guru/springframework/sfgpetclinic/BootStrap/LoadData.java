package guru.springframework.sfgpetclinic.BootStrap;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.model.vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


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
     ownerService.save(owner1);



        owner owner2= new owner();

        owner2.setFirstName("mahdi");
        owner2.setLastName("Karaz");
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
