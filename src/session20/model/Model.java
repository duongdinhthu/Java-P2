package session20.model;

import session20.entity.AddressBooks;
import session20.entity.Entity;

import java.util.ArrayList;
import java.util.List;



    public class Model<T extends Entity<?>>  {//<T extends Entity<?>> la cu phap mac dinh
        private List<T> entities = new ArrayList<>();// T dai dien cho cac thuc the entity( Product, Customer....)
        public void addEntity(T entity){
            entities.add(entity);

        }
        public List<T> getAllEntities(){
            return entities;
        }

        public T getEntityByPhone(int phone){
            for(T entity : entities){
                if(entity instanceof AddressBooks){
                    AddressBooks addressBook = (AddressBooks) entity;
                    if(String.valueOf(addressBook.getPhoneNumber()).equals(phone)){
                        return entity;
                    }
                }
            }
            return null;
        }

    }

