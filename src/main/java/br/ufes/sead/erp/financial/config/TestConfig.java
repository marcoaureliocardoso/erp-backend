package br.ufes.sead.erp.financial.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufes.sead.erp.financial.entities.Contract;
import br.ufes.sead.erp.financial.entities.ContractEventReminder;
import br.ufes.sead.erp.financial.entities.ContractEventReminderNote;
import br.ufes.sead.erp.financial.entities.Course;
import br.ufes.sead.erp.financial.entities.Employee;
import br.ufes.sead.erp.financial.entities.Grantor;
import br.ufes.sead.erp.financial.entities.Project;
import br.ufes.sead.erp.financial.entities.enums.EventType;
import br.ufes.sead.erp.financial.repositories.ContractEventReminderRepository;
import br.ufes.sead.erp.financial.repositories.ContractRepository;
import br.ufes.sead.erp.financial.repositories.CourseRepository;
import br.ufes.sead.erp.financial.repositories.EmployeeRepository;
import br.ufes.sead.erp.financial.repositories.GrantorRepository;
import br.ufes.sead.erp.financial.repositories.ProjectRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

        @Autowired
        private GrantorRepository grantorRepository;
        @Autowired
        private CourseRepository courseRepository;
        @Autowired
        private ProjectRepository projectRepository;
        @Autowired
        private EmployeeRepository employeeRepository;
        @Autowired
        private ContractRepository contractRepository;
        @Autowired
        private ContractEventReminderRepository contractEventRepository;

        @Override
        public void run(String... args) throws Exception {

                Grantor g1 = new Grantor("Tech Innovations Inc.");
                Grantor g2 = new Grantor("Global Health Foundation");
                Grantor g3 = new Grantor("Cybernetics Corp.");
                Grantor g4 = new Grantor("Oceanic Preservation Society");
                Grantor g5 = new Grantor("Future Tech Leaders");
                Grantor g6 = new Grantor("Urban Development Group");
                Grantor g7 = new Grantor("International Art Council");
                Grantor g8 = new Grantor("Sustainable Agriculture Network");
                Grantor g9 = new Grantor("Space Exploration Collective");
                Grantor g10 = new Grantor("Quantum Computing Lab");
                Grantor g11 = new Grantor("Historical Society");
                Grantor g12 = new Grantor("Global Linguistics Forum");
                Grantor g13 = new Grantor("Ocean Cleanup Initiative");
                Grantor g14 = new Grantor("Cyber Security Alliance");
                Grantor g15 = new Grantor("Artificial Intelligence Institute");

                grantorRepository.saveAll(
                                Arrays.asList(g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15));

                Course c1 = new Course("Renewable Energy Engineering");
                Course c2 = new Course("Medical Biotechnology");
                Course c3 = new Course("Artificial Intelligence and Ethics");
                Course c4 = new Course("Marine Biology and Conservation");
                Course c5 = new Course("Advanced Robotics and AI");
                Course c6 = new Course("Urban Planning and Sustainability");
                Course c7 = new Course("Art History and Restoration");
                Course c8 = new Course("Sustainable Agriculture Practices");
                Course c9 = new Course("Astrophysics and Space Engineering");
                Course c10 = new Course("Quantum Information Science");
                Course c11 = new Course("Archaeology and Anthropology");
                Course c12 = new Course("Linguistics and Language Preservation");
                Course c13 = new Course("Environmental Sciences and Policy");
                Course c14 = new Course("Cybersecurity and Digital Forensics");
                Course c15 = new Course("Health Informatics and AI");

                courseRepository.saveAll(
                                Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15));

                Project p1 = new Project("Green Energy Solutions", "GES001", g1, LocalDate.parse("2019-02-01"),
                                LocalDate.parse("2020-02-01"));
                Project p2 = new Project("Vaccine Research Program", "VRP002", g2, LocalDate.parse("2018-05-01"),
                                LocalDate.parse("2019-05-01"));
                Project p3 = new Project("AI for Good Initiative", "AGI003", g3, LocalDate.parse("2021-07-01"),
                                LocalDate.parse("2022-07-01"));
                Project p4 = new Project("Marine Biodiversity Project", "MBP004", g4,
                                LocalDate.parse("2017-03-01"),
                                LocalDate.parse("2018-03-01"));
                Project p5 = new Project("Youth Robotics Program", "YRP005", g5, LocalDate.parse("2022-10-01"),
                                LocalDate.parse("2023-10-01"));
                Project p6 = new Project("Smart Cities Initiative", "SCI006", g6, LocalDate.parse("2020-12-01"),
                                LocalDate.parse("2021-12-01"));
                Project p7 = new Project("Cultural Heritage Preservation", "CHP007", g7,
                                LocalDate.parse("2019-11-01"),
                                LocalDate.parse("2020-11-01"));
                Project p8 = new Project("Organic Farming Expansion", "OFE008", g8, LocalDate.parse("2021-04-01"),
                                LocalDate.parse("2022-04-01"));
                Project p9 = new Project("Mars Habitat Simulation", "MHS009", g9, LocalDate.parse("2019-07-01"),
                                LocalDate.parse("2020-07-01"));
                Project p10 = new Project("Quantum Algorithms Research", "QAR010", g10,
                                LocalDate.parse("2022-01-01"),
                                LocalDate.parse("2023-01-01"));
                Project p11 = new Project("Ancient Civilizations Study", "ACS011", g11,
                                LocalDate.parse("2020-09-01"),
                                LocalDate.parse("2021-09-01"));
                Project p12 = new Project("Endangered Languages Documentation", "ELD012", g12,
                                LocalDate.parse("2018-06-01"), LocalDate.parse("2019-06-01"));
                Project p13 = new Project("Plastic Pollution Reduction", "PPR013", g13,
                                LocalDate.parse("2021-05-01"),
                                LocalDate.parse("2022-05-01"));
                Project p14 = new Project("Data Protection Strategy", "DPS014", g14,
                                LocalDate.parse("2019-08-01"),
                                LocalDate.parse("2020-08-01"));
                Project p15 = new Project("AI in Healthcare", "AIH015", g15, LocalDate.parse("2022-03-01"),
                                LocalDate.parse("2023-03-01"));

                projectRepository.saveAll(
                                Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));

                Employee e1 = new Employee("John", "Doe", "12345756789", LocalDate.parse("1990-01-15"),
                                "john.doe@example.net");
                Employee e2 = new Employee("Jane", "Smith", "98765754321", LocalDate.parse("1988-05-20"),
                                "jane.smith@example.net");
                Employee e3 = new Employee("Jack", "Black", "12315723123", LocalDate.parse("1995-12-31"),
                                "jack.black@example.net");
                Employee e4 = new Employee("Jill", "White", "32135721321", LocalDate.parse("1993-06-30"),
                                "jill.white@example.net");
                Employee e5 = new Employee("Jim", "Green", "45576456456", LocalDate.parse("1991-03-15"),
                                "jim.green@example.net");
                Employee e6 = new Employee("Jenny", "Brown", "65465574654", LocalDate.parse("1994-09-15"),
                                "jenny.brown@example.net");
                Employee e7 = new Employee("Joe", "Grey", "78978579789", LocalDate.parse("1992-07-31"),
                                "joe.grey@example.net");
                Employee e8 = new Employee("Jessica", "Blue", "98795787987", LocalDate.parse("1996-11-30"),
                                "jessica.blue@example.net");
                Employee e9 = new Employee("James", "Red", "15915579159", LocalDate.parse("1997-02-28"),
                                "james.red@example.net");
                Employee e10 = new Employee("Julia", "Purple", "95195751951", LocalDate.parse("1998-10-31"),
                                "julia.purple@example.net");
                Employee e11 = new Employee("Jason", "Yellow", "75375357753", LocalDate.parse("1999-04-30"),
                                "jason.yellow@example.net");
                Employee e12 = new Employee("Jasmine", "Orange", "35735757357", LocalDate.parse("2000-08-31"),
                                "jasmine.orange@example.net");
                Employee e13 = new Employee("Justin", "Cyan", "25825578258", LocalDate.parse("2001-01-31"),
                                "justin.cyan@example.net");
                Employee e14 = new Employee("Jade", "Magenta", "85285257852", LocalDate.parse("2002-05-31"),
                                "jade.magenta@example.net");
                Employee e15 = new Employee("Jasper", "Violet", "45645576456", LocalDate.parse("2003-09-30"),
                                "jasper.violet@example.net");

                employeeRepository.saveAll(
                                Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15));

                Contract ct1 = new Contract(p1, c1, e1, LocalDate.parse("2019-02-01"));
                Contract ct2 = new Contract(p2, c2, e2, LocalDate.parse("2018-05-01"));
                Contract ct3 = new Contract(p3, c3, e3, LocalDate.parse("2021-07-01"));
                Contract ct4 = new Contract(p4, c4, e4, LocalDate.parse("2017-03-01"));
                Contract ct5 = new Contract(p5, c5, e5, LocalDate.parse("2022-10-01"));
                Contract ct6 = new Contract(p6, c6, e6, LocalDate.parse("2020-12-01"));
                Contract ct7 = new Contract(p7, c7, e7, LocalDate.parse("2019-11-01"));
                Contract ct8 = new Contract(p8, c8, e8, LocalDate.parse("2021-04-01"));
                Contract ct9 = new Contract(p9, c9, e9, LocalDate.parse("2019-07-01"));
                Contract ct10 = new Contract(p10, c10, e10, LocalDate.parse("2022-01-01"));
                Contract ct11 = new Contract(p11, c11, e11, LocalDate.parse("2020-09-01"));
                Contract ct12 = new Contract(p12, c12, e12, LocalDate.parse("2018-06-01"));
                Contract ct13 = new Contract(p13, c13, e13, LocalDate.parse("2021-05-01"));
                Contract ct14 = new Contract(p14, c14, e14, LocalDate.parse("2019-08-01"));
                Contract ct15 = new Contract(p15, c15, e15, LocalDate.parse("2022-03-01"));

                contractRepository.saveAll(Arrays.asList(ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8, ct9, ct10, ct11, ct12,
                                ct13, ct14, ct15));

                ContractEventReminder ce1 = new ContractEventReminder(ct1, EventType.RECESS1,
                                LocalDate.parse("2022-11-23"));
                ContractEventReminder ce2 = new ContractEventReminder(ct1, EventType.REPORT1_DELIVERY,
                                LocalDate.parse("2022-11-24"));
                ContractEventReminder ce3 = new ContractEventReminder(ct1, EventType.RECESS2,
                                LocalDate.parse("2023-05-24"));
                ContractEventReminder ce4 = new ContractEventReminder(ct1, EventType.REPORT2_DELIVERY,
                                LocalDate.parse("2023-05-25"));
                ContractEventReminder ce5 = new ContractEventReminder(ct1, EventType.CONTRACT_END,
                                LocalDate.parse("2023-07-09"));
                ContractEventReminder ce6 = new ContractEventReminder(ct2, EventType.RECESS1,
                                LocalDate.parse("2025-03-07"));
                ContractEventReminder ce7 = new ContractEventReminder(ct2, EventType.REPORT1_DELIVERY,
                                LocalDate.parse("2025-03-08"));
                ContractEventReminder ce8 = new ContractEventReminder(ct2, EventType.RECESS2,
                                LocalDate.parse("2025-09-07"));
                ContractEventReminder ce9 = new ContractEventReminder(ct2, EventType.REPORT2_DELIVERY,
                                LocalDate.parse("2025-09-08"));
                ContractEventReminder ce10 = new ContractEventReminder(ct2, EventType.CONTRACT_END,
                                LocalDate.parse("2025-10-23"));
                ContractEventReminder ce11 = new ContractEventReminder(ct3, EventType.RECESS1,
                                LocalDate.parse("2020-10-01"));
                ContractEventReminder ce12 = new ContractEventReminder(ct3, EventType.REPORT1_DELIVERY,
                                LocalDate.parse("2020-10-02"));
                ContractEventReminder ce13 = new ContractEventReminder(ct3, EventType.RECESS2,
                                LocalDate.parse("2021-04-01"));
                ContractEventReminder ce14 = new ContractEventReminder(ct3, EventType.REPORT2_DELIVERY,
                                LocalDate.parse("2021-04-02"));
                ContractEventReminder ce15 = new ContractEventReminder(ct3, EventType.CONTRACT_END,
                                LocalDate.parse("2021-05-17"));
                ContractEventReminder ce16 = new ContractEventReminder(ct4, EventType.RECESS1,
                                LocalDate.parse("2024-12-10"));
                ContractEventReminder ce17 = new ContractEventReminder(ct4, EventType.REPORT1_DELIVERY,
                                LocalDate.parse("2024-12-11"));
                ContractEventReminder ce18 = new ContractEventReminder(ct4, EventType.RECESS2,
                                LocalDate.parse("2025-06-10"));
                ContractEventReminder ce19 = new ContractEventReminder(ct4, EventType.REPORT2_DELIVERY,
                                LocalDate.parse("2025-06-11"));
                ContractEventReminder ce20 = new ContractEventReminder(ct4, EventType.CONTRACT_END,
                                LocalDate.parse("2025-07-26"));
                ContractEventReminder ce21 = new ContractEventReminder(ct5, EventType.RECESS1,
                                LocalDate.parse("2024-05-13"));
                ContractEventReminder ce22 = new ContractEventReminder(ct5, EventType.REPORT1_DELIVERY,
                                LocalDate.parse("2024-05-14"));
                ContractEventReminder ce23 = new ContractEventReminder(ct5, EventType.RECESS2,
                                LocalDate.parse("2024-11-13"));
                ContractEventReminder ce24 = new ContractEventReminder(ct5, EventType.REPORT2_DELIVERY,
                                LocalDate.parse("2024-11-14"));
                ContractEventReminder ce25 = new ContractEventReminder(ct5, EventType.CONTRACT_END,
                                LocalDate.parse("2024-12-29"));

                contractEventRepository.saveAll(Arrays.asList(ce1, ce2, ce3, ce4, ce5, ce6, ce7, ce8, ce9, ce10, ce11,
                                ce12, ce13, ce14, ce15, ce16, ce17, ce18, ce19, ce20, ce21, ce22, ce23, ce24, ce25));

                List<ContractEventReminder> contractEventReminders = contractEventRepository.findAll();

                for (ContractEventReminder contractEventReminder : contractEventReminders) {
                        ContractEventReminderNote note = new ContractEventReminderNote("Some notes " + contractEventReminder.getId() + ".", contractEventReminder);
                        contractEventReminder.setNote(note);

                        contractEventRepository.save(contractEventReminder);
                }
        }

}
