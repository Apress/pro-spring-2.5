package com.apress.prospring2.ch20.notification;

import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.jmx.export.notification.NotificationPublisher;

import javax.management.Notification;

/**
 * @author anirvanc
 */
public class SimpleSpringBean implements NotificationPublisherAware {
   private int notificationIndex = 0;
   private NotificationPublisher notificationPublisher;
   private String someValue = "Nada";

   public SimpleSpringBean()
   {
      // empty default constructor
   }

   public String getSomeValue()
   {
      return this.someValue;
   }

   public void setSomeValue(final String aSomeValue)
   {
      notificationPublisher.sendNotification(
         buildNotification(this.someValue, aSomeValue) );
      this.someValue = aSomeValue;
   }

   /**
    * Generate a Notification that will ultimately be published to interested
    * listeners.
    *
    * @param aOldValue Value prior to setting of new value.
    * @param aNewValue Value after setting of new value.
    * @return Generated JMX Notification.
    */
   private Notification buildNotification(
      final String aOldValue,
      final String aNewValue )
   {
      final String notificationType = "com.apress.prospring2.ch20.notification";
      final String message = "Converting " + aOldValue + " to " + aNewValue;
      final Notification notification =
         new Notification( notificationType,
                           this,
                           notificationIndex++,
                           System.currentTimeMillis(),
                           message );
      notification.setUserData("Example #" + notificationIndex );
      return notification;
   }

   /**
    * This is the only method required to fully implement the
    * NotificationPublisherAware interface.  This method allows Spring to
    * inject a NotificationPublisher into me.
    *
    * @param aPublisher The NotificationPublisher that Spring injects into me.
    */
   public void setNotificationPublisher(NotificationPublisher aPublisher)
   {
      this.notificationPublisher = aPublisher;
   }
}

