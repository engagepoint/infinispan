package org.infinispan.cli.commands.client;

import org.infinispan.cli.Context;
import org.infinispan.cli.commands.AbstractCommand;
import org.infinispan.cli.commands.ProcessedCommand;

public class Quit extends AbstractCommand {

   @Override
   public String getName() {
      return "quit";
   }

   @Override
   public boolean isAvailable(Context context) {
      return true;
   }

   @Override
   public void execute(Context context, ProcessedCommand commandLine) {
      context.setQuitting(true);
   }

}
