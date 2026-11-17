import { defineConfig } from "vitepress"

export default defineConfig({
  title: "Modern Java Handbook",
  description: "Production Reference Handbook & Concurrency Deep-Dive in Java 21 LTS",
  base: "/Java-handbook/",
  themeConfig: {
    nav: [
      {
            "text": "Home",
            "link": "/"
      },
      {
            "text": "Roadmap",
            "link": "/roadmap"
      },
      {
            "text": "Concurrency",
            "link": "/concurrency/virtualthreads/virtualthreadsdemo"
      },
      {
            "text": "Collections",
            "link": "/collections/maps/simplehashmap"
      },
      {
            "text": "Modern Java 21",
            "link": "/modern/recordsandsealed/paymentdomain"
      },
      {
            "text": "Security",
            "link": "/security/hashing/securepasswordhasher"
      },
      {
            "text": "GitHub",
            "link": "https://github.com/itsanurag-dev/Java-handbook"
      }
],
    sidebar: [
      {
            "text": "Overview",
            "items": [
                  {
                        "text": "Handbook Architecture & Overview",
                        "link": "/"
                  },
                  {
                        "text": "Curriculum & Learning Sequence",
                        "link": "/roadmap"
                  }
            ]
      },
      {
            "text": "Modern Java 21",
            "collapsed": false,
            "items": [
                  {
                        "text": "Modern / Recordsandsealed",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Paymentdomain",
                                    "link": "/modern/recordsandsealed/paymentdomain"
                              }
                        ]
                  }
            ]
      },
      {
            "text": "Concurrency & Multithreading",
            "collapsed": false,
            "items": [
                  {
                        "text": "Concurrency / Async",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Asyncpipelinedemo",
                                    "link": "/concurrency/async/asyncpipelinedemo"
                              }
                        ]
                  },
                  {
                        "text": "Concurrency / Coordination",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Callabletask",
                                    "link": "/concurrency/coordination/callabletask"
                              },
                              {
                                    "text": "Callabletaskdemo",
                                    "link": "/concurrency/coordination/callabletaskdemo"
                              },
                              {
                                    "text": "Classicdeadlockdemo",
                                    "link": "/concurrency/coordination/classicdeadlockdemo"
                              },
                              {
                                    "text": "Countdownlatch",
                                    "link": "/concurrency/coordination/countdownlatch"
                              },
                              {
                                    "text": "Countdownlatchfile",
                                    "link": "/concurrency/coordination/countdownlatchfile"
                              },
                              {
                                    "text": "Countdownlatchimpl",
                                    "link": "/concurrency/coordination/countdownlatchimpl"
                              },
                              {
                                    "text": "Joindeadlockdemo",
                                    "link": "/concurrency/coordination/joindeadlockdemo"
                              },
                              {
                                    "text": "Reentrantlockimpl",
                                    "link": "/concurrency/coordination/reentrantlockimpl"
                              },
                              {
                                    "text": "Semaphorethread",
                                    "link": "/concurrency/coordination/semaphorethread"
                              },
                              {
                                    "text": "Semaphorethreadimpl",
                                    "link": "/concurrency/coordination/semaphorethreadimpl"
                              },
                              {
                                    "text": "Sequentialdisplaydemo",
                                    "link": "/concurrency/coordination/sequentialdisplaydemo"
                              },
                              {
                                    "text": "Sequentialmessage",
                                    "link": "/concurrency/coordination/sequentialmessage"
                              },
                              {
                                    "text": "Sequentialprintingname",
                                    "link": "/concurrency/coordination/sequentialprintingname"
                              },
                              {
                                    "text": "Sequentialtablesprinting",
                                    "link": "/concurrency/coordination/sequentialtablesprinting"
                              },
                              {
                                    "text": "Sleepwaitnotifythread",
                                    "link": "/concurrency/coordination/sleepwaitnotifythread"
                              },
                              {
                                    "text": "Sleepwaitnotifythreaddemo",
                                    "link": "/concurrency/coordination/sleepwaitnotifythreaddemo"
                              },
                              {
                                    "text": "Threadcreations",
                                    "link": "/concurrency/coordination/threadcreations"
                              },
                              {
                                    "text": "Threadcreationsdemo",
                                    "link": "/concurrency/coordination/threadcreationsdemo"
                              },
                              {
                                    "text": "Threadresourceaquirecheckdemo",
                                    "link": "/concurrency/coordination/threadresourceaquirecheckdemo"
                              },
                              {
                                    "text": "Threadtwicestart",
                                    "link": "/concurrency/coordination/threadtwicestart"
                              },
                              {
                                    "text": "Yieldmethod",
                                    "link": "/concurrency/coordination/yieldmethod"
                              },
                              {
                                    "text": "Yieldmethoddemo",
                                    "link": "/concurrency/coordination/yieldmethoddemo"
                              }
                        ]
                  },
                  {
                        "text": "Concurrency / Executors",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Callablethread",
                                    "link": "/concurrency/executors/callablethread"
                              },
                              {
                                    "text": "Callablethreaddemo",
                                    "link": "/concurrency/executors/callablethreaddemo"
                              },
                              {
                                    "text": "Processagentdata",
                                    "link": "/concurrency/executors/processagentdata"
                              },
                              {
                                    "text": "Threadpoolimpl",
                                    "link": "/concurrency/executors/threadpoolimpl"
                              },
                              {
                                    "text": "Threadpoolworker",
                                    "link": "/concurrency/executors/threadpoolworker"
                              },
                              {
                                    "text": "Workerthread",
                                    "link": "/concurrency/executors/workerthread"
                              },
                              {
                                    "text": "Workerthreadexecuterdemo",
                                    "link": "/concurrency/executors/workerthreadexecuterdemo"
                              }
                        ]
                  },
                  {
                        "text": "Concurrency / Latches",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Countdownlatchimpl",
                                    "link": "/concurrency/latches/countdownlatchimpl"
                              }
                        ]
                  },
                  {
                        "text": "Concurrency / Producerconsumer",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Boundedblockingqueue",
                                    "link": "/concurrency/producerconsumer/boundedblockingqueue"
                              },
                              {
                                    "text": "Elementpcdemo",
                                    "link": "/concurrency/producerconsumer/elementpcdemo"
                              },
                              {
                                    "text": "Elementspc",
                                    "link": "/concurrency/producerconsumer/elementspc"
                              },
                              {
                                    "text": "Innerclassesspcdemo",
                                    "link": "/concurrency/producerconsumer/innerclassesspcdemo"
                              },
                              {
                                    "text": "Sharedresourcepc",
                                    "link": "/concurrency/producerconsumer/sharedresourcepc"
                              },
                              {
                                    "text": "Sharedresourcepcdemo",
                                    "link": "/concurrency/producerconsumer/sharedresourcepcdemo"
                              }
                        ]
                  },
                  {
                        "text": "Concurrency / Threads",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Concurrentmodificationexception",
                                    "link": "/concurrency/threads/concurrentmodificationexception"
                              },
                              {
                                    "text": "Daemonthread",
                                    "link": "/concurrency/threads/daemonthread"
                              },
                              {
                                    "text": "Initilizeingthread",
                                    "link": "/concurrency/threads/initilizeingthread"
                              },
                              {
                                    "text": "Joinmethodimpl",
                                    "link": "/concurrency/threads/joinmethodimpl"
                              },
                              {
                                    "text": "Joinmethodrawcode",
                                    "link": "/concurrency/threads/joinmethodrawcode"
                              },
                              {
                                    "text": "Joinyieldimplementation",
                                    "link": "/concurrency/threads/joinyieldimplementation"
                              },
                              {
                                    "text": "Lambdaexpression",
                                    "link": "/concurrency/threads/lambdaexpression"
                              },
                              {
                                    "text": "Lambdathread",
                                    "link": "/concurrency/threads/lambdathread"
                              },
                              {
                                    "text": "Lambdathreadimpl",
                                    "link": "/concurrency/threads/lambdathreadimpl"
                              },
                              {
                                    "text": "Listproducerconsumer",
                                    "link": "/concurrency/threads/listproducerconsumer"
                              },
                              {
                                    "text": "Listproducerconsumerimpl",
                                    "link": "/concurrency/threads/listproducerconsumerimpl"
                              },
                              {
                                    "text": "Message",
                                    "link": "/concurrency/threads/message"
                              },
                              {
                                    "text": "Messageconsumer",
                                    "link": "/concurrency/threads/messageconsumer"
                              },
                              {
                                    "text": "Messageproducer",
                                    "link": "/concurrency/threads/messageproducer"
                              },
                              {
                                    "text": "Messagequeue",
                                    "link": "/concurrency/threads/messagequeue"
                              },
                              {
                                    "text": "Messagequeueconsumer",
                                    "link": "/concurrency/threads/messagequeueconsumer"
                              },
                              {
                                    "text": "Messagequeuenotifier",
                                    "link": "/concurrency/threads/messagequeuenotifier"
                              },
                              {
                                    "text": "Messagequeuepcimpl",
                                    "link": "/concurrency/threads/messagequeuepcimpl"
                              },
                              {
                                    "text": "Messagequeueproducer",
                                    "link": "/concurrency/threads/messagequeueproducer"
                              },
                              {
                                    "text": "Messagequeuewaiter",
                                    "link": "/concurrency/threads/messagequeuewaiter"
                              },
                              {
                                    "text": "Messagequeuewaitnotifyimpl",
                                    "link": "/concurrency/threads/messagequeuewaitnotifyimpl"
                              },
                              {
                                    "text": "Notifier",
                                    "link": "/concurrency/threads/notifier"
                              },
                              {
                                    "text": "Printingthreadinlogs",
                                    "link": "/concurrency/threads/printingthreadinlogs"
                              },
                              {
                                    "text": "Producerconsumerimpl",
                                    "link": "/concurrency/threads/producerconsumerimpl"
                              },
                              {
                                    "text": "Runthread",
                                    "link": "/concurrency/threads/runthread"
                              },
                              {
                                    "text": "Sequentialoddevengeneric",
                                    "link": "/concurrency/threads/sequentialoddevengeneric"
                              },
                              {
                                    "text": "Sequentialoddevengenericimpl",
                                    "link": "/concurrency/threads/sequentialoddevengenericimpl"
                              },
                              {
                                    "text": "Sequentialoddevenprinting",
                                    "link": "/concurrency/threads/sequentialoddevenprinting"
                              },
                              {
                                    "text": "Sequentialprintingwithnthread",
                                    "link": "/concurrency/threads/sequentialprintingwithnthread"
                              },
                              {
                                    "text": "Sequentialprintingwithnthreadimpl",
                                    "link": "/concurrency/threads/sequentialprintingwithnthreadimpl"
                              },
                              {
                                    "text": "Sequentialtableprinting",
                                    "link": "/concurrency/threads/sequentialtableprinting"
                              },
                              {
                                    "text": "Simplethreadpool",
                                    "link": "/concurrency/threads/simplethreadpool"
                              },
                              {
                                    "text": "Threaddeadlocak",
                                    "link": "/concurrency/threads/threaddeadlocak"
                              },
                              {
                                    "text": "Threaddeadlocakdemo",
                                    "link": "/concurrency/threads/threaddeadlocakdemo"
                              },
                              {
                                    "text": "Threaddeadlocakusingmainthread",
                                    "link": "/concurrency/threads/threaddeadlocakusingmainthread"
                              },
                              {
                                    "text": "Threaddeadlocakusingtwothread",
                                    "link": "/concurrency/threads/threaddeadlocakusingtwothread"
                              },
                              {
                                    "text": "Threadjoining",
                                    "link": "/concurrency/threads/threadjoining"
                              },
                              {
                                    "text": "Threadjoiningimpl",
                                    "link": "/concurrency/threads/threadjoiningimpl"
                              },
                              {
                                    "text": "Threadlocalimpl",
                                    "link": "/concurrency/threads/threadlocalimpl"
                              },
                              {
                                    "text": "Threadlogprinting",
                                    "link": "/concurrency/threads/threadlogprinting"
                              },
                              {
                                    "text": "Validatesequentialprinting",
                                    "link": "/concurrency/threads/validatesequentialprinting"
                              },
                              {
                                    "text": "Validatesequentialprintingdemo",
                                    "link": "/concurrency/threads/validatesequentialprintingdemo"
                              },
                              {
                                    "text": "Validatewaitnotify_Pc",
                                    "link": "/concurrency/threads/validatewaitnotify_pc"
                              },
                              {
                                    "text": "Waiter",
                                    "link": "/concurrency/threads/waiter"
                              },
                              {
                                    "text": "Waiternotifierimpl",
                                    "link": "/concurrency/threads/waiternotifierimpl"
                              },
                              {
                                    "text": "Waitnotifylistpc",
                                    "link": "/concurrency/threads/waitnotifylistpc"
                              },
                              {
                                    "text": "Waitnotifylistpcimpl",
                                    "link": "/concurrency/threads/waitnotifylistpcimpl"
                              },
                              {
                                    "text": "Waitnotifypcimpl",
                                    "link": "/concurrency/threads/waitnotifypcimpl"
                              },
                              {
                                    "text": "Workerthread",
                                    "link": "/concurrency/threads/workerthread"
                              },
                              {
                                    "text": "Writingthreadstatus",
                                    "link": "/concurrency/threads/writingthreadstatus"
                              }
                        ]
                  },
                  {
                        "text": "Concurrency / Virtualthreads",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Virtualthreadsdemo",
                                    "link": "/concurrency/virtualthreads/virtualthreadsdemo"
                              }
                        ]
                  }
            ]
      },
      {
            "text": "Collections Framework",
            "collapsed": false,
            "items": [
                  {
                        "text": "Collections / Maps",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Employee",
                                    "link": "/collections/maps/employee"
                              },
                              {
                                    "text": "Employeedemo",
                                    "link": "/collections/maps/employeedemo"
                              },
                              {
                                    "text": "Executerwithconcurrenthashmap",
                                    "link": "/collections/maps/executerwithconcurrenthashmap"
                              },
                              {
                                    "text": "Hashcodeandequals",
                                    "link": "/collections/maps/hashcodeandequals"
                              },
                              {
                                    "text": "Hashcodeimplemention",
                                    "link": "/collections/maps/hashcodeimplemention"
                              },
                              {
                                    "text": "Hashmapintro",
                                    "link": "/collections/maps/hashmapintro"
                              },
                              {
                                    "text": "Hashmapoperations",
                                    "link": "/collections/maps/hashmapoperations"
                              },
                              {
                                    "text": "Javamapemployee",
                                    "link": "/collections/maps/javamapemployee"
                              },
                              {
                                    "text": "Javamapemployeedemo",
                                    "link": "/collections/maps/javamapemployeedemo"
                              },
                              {
                                    "text": "Lrucasheimplementation",
                                    "link": "/collections/maps/lrucasheimplementation"
                              },
                              {
                                    "text": "Node",
                                    "link": "/collections/maps/node"
                              },
                              {
                                    "text": "Priceforhashcodeimplementation",
                                    "link": "/collections/maps/priceforhashcodeimplementation"
                              },
                              {
                                    "text": "Simplehashmap",
                                    "link": "/collections/maps/simplehashmap"
                              },
                              {
                                    "text": "Sizeofmap",
                                    "link": "/collections/maps/sizeofmap"
                              },
                              {
                                    "text": "Sortarraymap",
                                    "link": "/collections/maps/sortarraymap"
                              },
                              {
                                    "text": "Stringmanipulation1",
                                    "link": "/collections/maps/stringmanipulation1"
                              }
                        ]
                  },
                  {
                        "text": "Collections / Sorting",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Agecomparator",
                                    "link": "/collections/sorting/agecomparator"
                              },
                              {
                                    "text": "Employee",
                                    "link": "/collections/sorting/employee"
                              },
                              {
                                    "text": "Employeecomparable",
                                    "link": "/collections/sorting/employeecomparable"
                              },
                              {
                                    "text": "Employeecomparabledemo",
                                    "link": "/collections/sorting/employeecomparabledemo"
                              },
                              {
                                    "text": "Employeecomparator",
                                    "link": "/collections/sorting/employeecomparator"
                              },
                              {
                                    "text": "Employeecomparatordemo",
                                    "link": "/collections/sorting/employeecomparatordemo"
                              },
                              {
                                    "text": "Employeecomparatorimpl",
                                    "link": "/collections/sorting/employeecomparatorimpl"
                              },
                              {
                                    "text": "Hashmapcomparator",
                                    "link": "/collections/sorting/hashmapcomparator"
                              },
                              {
                                    "text": "Hashmapcomparatorimpl",
                                    "link": "/collections/sorting/hashmapcomparatorimpl"
                              },
                              {
                                    "text": "Hashmapsorting",
                                    "link": "/collections/sorting/hashmapsorting"
                              },
                              {
                                    "text": "Jobtitlecomparator",
                                    "link": "/collections/sorting/jobtitlecomparator"
                              },
                              {
                                    "text": "Mapcomparator",
                                    "link": "/collections/sorting/mapcomparator"
                              },
                              {
                                    "text": "Namecomparator",
                                    "link": "/collections/sorting/namecomparator"
                              },
                              {
                                    "text": "Pricecomparator",
                                    "link": "/collections/sorting/pricecomparator"
                              },
                              {
                                    "text": "Pricecomparatordemo",
                                    "link": "/collections/sorting/pricecomparatordemo"
                              },
                              {
                                    "text": "Pricecomparatorimpl",
                                    "link": "/collections/sorting/pricecomparatorimpl"
                              },
                              {
                                    "text": "Salarycomparator",
                                    "link": "/collections/sorting/salarycomparator"
                              }
                        ]
                  }
            ]
      },
      {
            "text": "Object-Oriented Design",
            "collapsed": true,
            "items": [
                  {
                        "text": "Oop / Core",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Arraylistimpl",
                                    "link": "/oop/core/arraylistimpl"
                              },
                              {
                                    "text": "Balancedparenthiese",
                                    "link": "/oop/core/balancedparenthiese"
                              },
                              {
                                    "text": "Checkprotecteddefaultmethod",
                                    "link": "/oop/core/checkprotecteddefaultmethod"
                              },
                              {
                                    "text": "Customer",
                                    "link": "/oop/core/customer"
                              },
                              {
                                    "text": "Customerhashcode",
                                    "link": "/oop/core/customerhashcode"
                              },
                              {
                                    "text": "Datahiding",
                                    "link": "/oop/core/datahiding"
                              },
                              {
                                    "text": "Defaultmethod",
                                    "link": "/oop/core/defaultmethod"
                              },
                              {
                                    "text": "Employee",
                                    "link": "/oop/core/employee"
                              },
                              {
                                    "text": "Employeecomparable",
                                    "link": "/oop/core/employeecomparable"
                              },
                              {
                                    "text": "Employeecomparabledemo",
                                    "link": "/oop/core/employeecomparabledemo"
                              },
                              {
                                    "text": "Employeecomparator",
                                    "link": "/oop/core/employeecomparator"
                              },
                              {
                                    "text": "Employeecomparatordemo",
                                    "link": "/oop/core/employeecomparatordemo"
                              },
                              {
                                    "text": "Hangmangame",
                                    "link": "/oop/core/hangmangame"
                              },
                              {
                                    "text": "Inheritance_Child",
                                    "link": "/oop/core/inheritance_child"
                              },
                              {
                                    "text": "Inheritance_Driver",
                                    "link": "/oop/core/inheritance_driver"
                              },
                              {
                                    "text": "Inheritance_Parent",
                                    "link": "/oop/core/inheritance_parent"
                              },
                              {
                                    "text": "Lrucache",
                                    "link": "/oop/core/lrucache"
                              },
                              {
                                    "text": "Minstack",
                                    "link": "/oop/core/minstack"
                              },
                              {
                                    "text": "Overloading",
                                    "link": "/oop/core/overloading"
                              },
                              {
                                    "text": "Person",
                                    "link": "/oop/core/person"
                              },
                              {
                                    "text": "Personhashcode",
                                    "link": "/oop/core/personhashcode"
                              },
                              {
                                    "text": "Polychild",
                                    "link": "/oop/core/polychild"
                              },
                              {
                                    "text": "Polydemochild",
                                    "link": "/oop/core/polydemochild"
                              },
                              {
                                    "text": "Polydemoparent",
                                    "link": "/oop/core/polydemoparent"
                              },
                              {
                                    "text": "Polyparent",
                                    "link": "/oop/core/polyparent"
                              },
                              {
                                    "text": "Protectedmethod",
                                    "link": "/oop/core/protectedmethod"
                              },
                              {
                                    "text": "Redundantbraces",
                                    "link": "/oop/core/redundantbraces"
                              },
                              {
                                    "text": "Reentrantlockdemo",
                                    "link": "/oop/core/reentrantlockdemo"
                              },
                              {
                                    "text": "Testinterface",
                                    "link": "/oop/core/testinterface"
                              },
                              {
                                    "text": "Unixabsolutepath",
                                    "link": "/oop/core/unixabsolutepath"
                              },
                              {
                                    "text": "Validator",
                                    "link": "/oop/core/validator"
                              },
                              {
                                    "text": "Validatorimpl",
                                    "link": "/oop/core/validatorimpl"
                              }
                        ]
                  },
                  {
                        "text": "Oop / Creational",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Threadsafesingleton",
                                    "link": "/oop/creational/threadsafesingleton"
                              }
                        ]
                  },
                  {
                        "text": "Oop / Immutability",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Employeebean",
                                    "link": "/oop/immutability/employeebean"
                              },
                              {
                                    "text": "Imutableclasswithmutableprimitiveobject",
                                    "link": "/oop/immutability/imutableclasswithmutableprimitiveobject"
                              },
                              {
                                    "text": "Imutableclasswithmutableprimitiveobjectdemo",
                                    "link": "/oop/immutability/imutableclasswithmutableprimitiveobjectdemo"
                              }
                        ]
                  }
            ]
      },
      {
            "text": "Language Fundamentals",
            "collapsed": true,
            "items": [
                  {
                        "text": "Fundamentals / Arrays",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Arrayutil",
                                    "link": "/fundamentals/arrays/arrayutil"
                              },
                              {
                                    "text": "Genericdateformatter",
                                    "link": "/fundamentals/arrays/genericdateformatter"
                              },
                              {
                                    "text": "Javapassbyvalue",
                                    "link": "/fundamentals/arrays/javapassbyvalue"
                              },
                              {
                                    "text": "Largestsubarray",
                                    "link": "/fundamentals/arrays/largestsubarray"
                              },
                              {
                                    "text": "Longestpalimdrom",
                                    "link": "/fundamentals/arrays/longestpalimdrom"
                              },
                              {
                                    "text": "Longestsubstring",
                                    "link": "/fundamentals/arrays/longestsubstring"
                              },
                              {
                                    "text": "Primenumber",
                                    "link": "/fundamentals/arrays/primenumber"
                              },
                              {
                                    "text": "Restrictobjectcreation",
                                    "link": "/fundamentals/arrays/restrictobjectcreation"
                              },
                              {
                                    "text": "Reverseafternelements",
                                    "link": "/fundamentals/arrays/reverseafternelements"
                              },
                              {
                                    "text": "Reversearrayrecursive",
                                    "link": "/fundamentals/arrays/reversearrayrecursive"
                              },
                              {
                                    "text": "Reversestring",
                                    "link": "/fundamentals/arrays/reversestring"
                              },
                              {
                                    "text": "Reversingarray",
                                    "link": "/fundamentals/arrays/reversingarray"
                              },
                              {
                                    "text": "Rotatearraydemo",
                                    "link": "/fundamentals/arrays/rotatearraydemo"
                              },
                              {
                                    "text": "Rotatearraydemo1",
                                    "link": "/fundamentals/arrays/rotatearraydemo1"
                              }
                        ]
                  },
                  {
                        "text": "Fundamentals / Basics",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Abstractstatic",
                                    "link": "/fundamentals/basics/abstractstatic"
                              },
                              {
                                    "text": "Abstractstaticdemo",
                                    "link": "/fundamentals/basics/abstractstaticdemo"
                              },
                              {
                                    "text": "Alternatesortarray",
                                    "link": "/fundamentals/basics/alternatesortarray"
                              },
                              {
                                    "text": "Beforecurrentdate",
                                    "link": "/fundamentals/basics/beforecurrentdate"
                              },
                              {
                                    "text": "Constrchainingdemo",
                                    "link": "/fundamentals/basics/constrchainingdemo"
                              },
                              {
                                    "text": "Constructorchainingdemo",
                                    "link": "/fundamentals/basics/constructorchainingdemo"
                              },
                              {
                                    "text": "Constructorchainsub",
                                    "link": "/fundamentals/basics/constructorchainsub"
                              },
                              {
                                    "text": "Constructorchainsuper",
                                    "link": "/fundamentals/basics/constructorchainsuper"
                              },
                              {
                                    "text": "Enumimpl",
                                    "link": "/fundamentals/basics/enumimpl"
                              },
                              {
                                    "text": "Fibonaccicalculator",
                                    "link": "/fundamentals/basics/fibonaccicalculator"
                              },
                              {
                                    "text": "Frequencyofarrayelement",
                                    "link": "/fundamentals/basics/frequencyofarrayelement"
                              },
                              {
                                    "text": "Genericreturnmethod",
                                    "link": "/fundamentals/basics/genericreturnmethod"
                              },
                              {
                                    "text": "Immutableclassdemo",
                                    "link": "/fundamentals/basics/immutableclassdemo"
                              },
                              {
                                    "text": "Immutableemployee",
                                    "link": "/fundamentals/basics/immutableemployee"
                              },
                              {
                                    "text": "Initializerblock",
                                    "link": "/fundamentals/basics/initializerblock"
                              },
                              {
                                    "text": "Javatoturialenum",
                                    "link": "/fundamentals/basics/javatoturialenum"
                              },
                              {
                                    "text": "Lambdahelloworld",
                                    "link": "/fundamentals/basics/lambdahelloworld"
                              },
                              {
                                    "text": "Largestandsmallestinarray",
                                    "link": "/fundamentals/basics/largestandsmallestinarray"
                              },
                              {
                                    "text": "Largestsubarray",
                                    "link": "/fundamentals/basics/largestsubarray"
                              },
                              {
                                    "text": "Longestpalimdrom",
                                    "link": "/fundamentals/basics/longestpalimdrom"
                              },
                              {
                                    "text": "Longestsubstring",
                                    "link": "/fundamentals/basics/longestsubstring"
                              },
                              {
                                    "text": "Objecthierarchy",
                                    "link": "/fundamentals/basics/objecthierarchy"
                              },
                              {
                                    "text": "Overloading",
                                    "link": "/fundamentals/basics/overloading"
                              },
                              {
                                    "text": "Overloadingdemo",
                                    "link": "/fundamentals/basics/overloadingdemo"
                              },
                              {
                                    "text": "Overrinding",
                                    "link": "/fundamentals/basics/overrinding"
                              },
                              {
                                    "text": "Pattern",
                                    "link": "/fundamentals/basics/pattern"
                              },
                              {
                                    "text": "Polymorphism",
                                    "link": "/fundamentals/basics/polymorphism"
                              },
                              {
                                    "text": "Primenumber",
                                    "link": "/fundamentals/basics/primenumber"
                              },
                              {
                                    "text": "Restrictobjectcreation",
                                    "link": "/fundamentals/basics/restrictobjectcreation"
                              },
                              {
                                    "text": "Reversearray",
                                    "link": "/fundamentals/basics/reversearray"
                              },
                              {
                                    "text": "Reversestring",
                                    "link": "/fundamentals/basics/reversestring"
                              },
                              {
                                    "text": "Reversingarray",
                                    "link": "/fundamentals/basics/reversingarray"
                              },
                              {
                                    "text": "Runnabletest",
                                    "link": "/fundamentals/basics/runnabletest"
                              },
                              {
                                    "text": "Shutdownhook",
                                    "link": "/fundamentals/basics/shutdownhook"
                              },
                              {
                                    "text": "Staticinterfaceimpl",
                                    "link": "/fundamentals/basics/staticinterfaceimpl"
                              },
                              {
                                    "text": "Staticinterfacetest",
                                    "link": "/fundamentals/basics/staticinterfacetest"
                              },
                              {
                                    "text": "Stringequalscheck",
                                    "link": "/fundamentals/basics/stringequalscheck"
                              },
                              {
                                    "text": "Student",
                                    "link": "/fundamentals/basics/student"
                              },
                              {
                                    "text": "Taxcalculator",
                                    "link": "/fundamentals/basics/taxcalculator"
                              },
                              {
                                    "text": "Threaddemo",
                                    "link": "/fundamentals/basics/threaddemo"
                              },
                              {
                                    "text": "Threadtest",
                                    "link": "/fundamentals/basics/threadtest"
                              },
                              {
                                    "text": "Useofenum",
                                    "link": "/fundamentals/basics/useofenum"
                              },
                              {
                                    "text": "Useofenum2",
                                    "link": "/fundamentals/basics/useofenum2"
                              },
                              {
                                    "text": "Wrapperdemo",
                                    "link": "/fundamentals/basics/wrapperdemo"
                              }
                        ]
                  },
                  {
                        "text": "Fundamentals / Constants",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Constants",
                                    "link": "/fundamentals/constants/constants"
                              }
                        ]
                  },
                  {
                        "text": "Fundamentals / Utility",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Stringtosql",
                                    "link": "/fundamentals/utility/stringtosql"
                              }
                        ]
                  }
            ]
      },
      {
            "text": "Functional Programming",
            "collapsed": true,
            "items": [
                  {
                        "text": "Functional / Lambdas",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Funcinterface",
                                    "link": "/functional/lambdas/funcinterface"
                              },
                              {
                                    "text": "Lambdacombinations",
                                    "link": "/functional/lambdas/lambdacombinations"
                              },
                              {
                                    "text": "Lambdaexpression",
                                    "link": "/functional/lambdas/lambdaexpression"
                              },
                              {
                                    "text": "Person",
                                    "link": "/functional/lambdas/person"
                              },
                              {
                                    "text": "Personcompare",
                                    "link": "/functional/lambdas/personcompare"
                              },
                              {
                                    "text": "Runnablelambda",
                                    "link": "/functional/lambdas/runnablelambda"
                              }
                        ]
                  },
                  {
                        "text": "Functional / Streams",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Streamcombinations",
                                    "link": "/functional/streams/streamcombinations"
                              }
                        ]
                  }
            ]
      },
      {
            "text": "Security & Cryptography",
            "collapsed": true,
            "items": [
                  {
                        "text": "Security / Encryption",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Cryptography",
                                    "link": "/security/encryption/cryptography"
                              },
                              {
                                    "text": "Encryption",
                                    "link": "/security/encryption/encryption"
                              },
                              {
                                    "text": "Encryptiondecryptionaes",
                                    "link": "/security/encryption/encryptiondecryptionaes"
                              },
                              {
                                    "text": "Filedecryption",
                                    "link": "/security/encryption/filedecryption"
                              },
                              {
                                    "text": "Fileencryption",
                                    "link": "/security/encryption/fileencryption"
                              }
                        ]
                  },
                  {
                        "text": "Security / Hashing",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Securepasswordhasher",
                                    "link": "/security/hashing/securepasswordhasher"
                              }
                        ]
                  }
            ]
      },
      {
            "text": "I/O, Persistence & Exceptions",
            "collapsed": true,
            "items": [
                  {
                        "text": "Io / Serialization",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Animal",
                                    "link": "/io/serialization/animal"
                              },
                              {
                                    "text": "Constants",
                                    "link": "/io/serialization/constants"
                              },
                              {
                                    "text": "Constructorserilization",
                                    "link": "/io/serialization/constructorserilization"
                              },
                              {
                                    "text": "Constructorserilizationdemo",
                                    "link": "/io/serialization/constructorserilizationdemo"
                              },
                              {
                                    "text": "Customizeserialization",
                                    "link": "/io/serialization/customizeserialization"
                              },
                              {
                                    "text": "Customizeserializationdemo",
                                    "link": "/io/serialization/customizeserializationdemo"
                              },
                              {
                                    "text": "Deserilizationdemo",
                                    "link": "/io/serialization/deserilizationdemo"
                              },
                              {
                                    "text": "Dog",
                                    "link": "/io/serialization/dog"
                              },
                              {
                                    "text": "Externalization",
                                    "link": "/io/serialization/externalization"
                              },
                              {
                                    "text": "Externalizationdemo",
                                    "link": "/io/serialization/externalizationdemo"
                              },
                              {
                                    "text": "Genericserilisation",
                                    "link": "/io/serialization/genericserilisation"
                              },
                              {
                                    "text": "Parentserilization",
                                    "link": "/io/serialization/parentserilization"
                              },
                              {
                                    "text": "Parentserilizationdemo",
                                    "link": "/io/serialization/parentserilizationdemo"
                              },
                              {
                                    "text": "Parentserilizationimpl",
                                    "link": "/io/serialization/parentserilizationimpl"
                              },
                              {
                                    "text": "Serializationdemo",
                                    "link": "/io/serialization/serializationdemo"
                              },
                              {
                                    "text": "Serilizationutil",
                                    "link": "/io/serialization/serilizationutil"
                              }
                        ]
                  },
                  {
                        "text": "Io / Streams",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Configs",
                                    "link": "/io/streams/configs"
                              },
                              {
                                    "text": "Configsdemo",
                                    "link": "/io/streams/configsdemo"
                              },
                              {
                                    "text": "Marketinterafeceserialization",
                                    "link": "/io/streams/marketinterafeceserialization"
                              },
                              {
                                    "text": "Readingdatafromfile",
                                    "link": "/io/streams/readingdatafromfile"
                              },
                              {
                                    "text": "Writingdatatofile",
                                    "link": "/io/streams/writingdatatofile"
                              }
                        ]
                  },
                  {
                        "text": "Jdbc / Statements",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Jdbcconnection",
                                    "link": "/jdbc/statements/jdbcconnection"
                              },
                              {
                                    "text": "Resultsetselect",
                                    "link": "/jdbc/statements/resultsetselect"
                              }
                        ]
                  },
                  {
                        "text": "Exceptions / Handling",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Confignotfoundexception",
                                    "link": "/exceptions/handling/confignotfoundexception"
                              },
                              {
                                    "text": "Customexceptiontest",
                                    "link": "/exceptions/handling/customexceptiontest"
                              },
                              {
                                    "text": "Invalidageexception",
                                    "link": "/exceptions/handling/invalidageexception"
                              },
                              {
                                    "text": "Multicatch",
                                    "link": "/exceptions/handling/multicatch"
                              },
                              {
                                    "text": "Outofmemoryerrordemo",
                                    "link": "/exceptions/handling/outofmemoryerrordemo"
                              },
                              {
                                    "text": "Trywithresources",
                                    "link": "/exceptions/handling/trywithresources"
                              }
                        ]
                  },
                  {
                        "text": "Generics",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Genericreturnmethod",
                                    "link": "/generics/genericreturnmethod"
                              },
                              {
                                    "text": "Passvaluegenerics",
                                    "link": "/generics/passvaluegenerics"
                              },
                              {
                                    "text": "Processdatabygenerics",
                                    "link": "/generics/processdatabygenerics"
                              }
                        ]
                  },
                  {
                        "text": "Reflection",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Bizrequest",
                                    "link": "/reflection/bizrequest"
                              },
                              {
                                    "text": "Cashin",
                                    "link": "/reflection/cashin"
                              },
                              {
                                    "text": "Configs",
                                    "link": "/reflection/configs"
                              },
                              {
                                    "text": "Objectfactory",
                                    "link": "/reflection/objectfactory"
                              }
                        ]
                  }
            ]
      },
      {
            "text": "Interview Problems & Algorithms",
            "collapsed": true,
            "items": [
                  {
                        "text": "Interview / Algorithms",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Firstnonrepitativestring",
                                    "link": "/interview/algorithms/firstnonrepitativestring"
                              },
                              {
                                    "text": "Firstrepitativestring",
                                    "link": "/interview/algorithms/firstrepitativestring"
                              },
                              {
                                    "text": "Genericcalculator",
                                    "link": "/interview/algorithms/genericcalculator"
                              }
                        ]
                  },
                  {
                        "text": "Interview / Patterns",
                        "collapsed": true,
                        "items": [
                              {
                                    "text": "Pattern1",
                                    "link": "/interview/patterns/pattern1"
                              },
                              {
                                    "text": "Pattern2",
                                    "link": "/interview/patterns/pattern2"
                              },
                              {
                                    "text": "Pattern3",
                                    "link": "/interview/patterns/pattern3"
                              },
                              {
                                    "text": "Pattern4",
                                    "link": "/interview/patterns/pattern4"
                              },
                              {
                                    "text": "Pattern5",
                                    "link": "/interview/patterns/pattern5"
                              },
                              {
                                    "text": "Starpattern",
                                    "link": "/interview/patterns/starpattern"
                              }
                        ]
                  }
            ]
      }
],
    socialLinks: [
      { icon: "github", link: "https://github.com/itsanurag-dev/Java-handbook" }
    ],
    footer: {
      message: "Released under the Apache 2.0 License.",
      copyright: "Copyright © 2026 Anurag Tiwari"
    }
  }
})
